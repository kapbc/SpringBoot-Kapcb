package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.component.HttpClientComponent;
import com.kapcb.ccc.service.ElasticsearchService;
import org.apache.http.HttpEntity;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/28 22:11
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    private static final Logger log = LoggerFactory.getLogger(ElasticsearchServiceImpl.class);

    private static final RequestOptions REQUEST_OPTIONS;

    private static final int BUFFER_LIMIT_BYTES = 30 * 1024 * 1024 * 1024;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // token表示为所有请求添加所需的请求头
        // addHeader用于授权或在Elasticsearch前使用代理所需的头信息。在使用时, 不需要Content-Type头,
        // 因为客户端将自动在请求的HttpEntity中设置Content-Type头
        // 创建好单实例的COMMON_OPTIONS之后即可在每个请求发出时使用它
        builder.addHeader("Authorization", "Bearer " + "myToken");
        builder.setHttpAsyncResponseConsumerFactory(new HttpAsyncResponseConsumerFactory
                .HeapBufferedResponseConsumerFactory(BUFFER_LIMIT_BYTES));
        REQUEST_OPTIONS = builder.build();
    }

    @Resource
    private HttpClientComponent httpClientComponent;

    /**
     * 构建对Elasticsearch的同步请求
     *
     * @return String
     */
    @Override
    public String executeRequest() {

        // restful 风格的请求
        Request request = new Request("GET", "/");

        // 设置Elasticsearch请求返回结果为格式化后的json串
        request.addParameter("pretty", "true");

        // 将请求的主体设置为任意的HttpEntity
        //request.setEntity(new NStringEntity("{\"json\":\"text\"}", ContentType.APPLICATION_JSON));

        // 还可以将其设置为一个字符串, 在Elasticsearch中, 默认使用application/json的内容格式, 设置方式如下:
        request.setJsonEntity("{\"json\":\"text\"}");
        try {

            Response response = httpClientComponent.restClient.performRequest(request);
            return response.toString();
        } catch (Exception e) {
            log.error("elasticsearch rest client preform request fail! error message is : " + e.getMessage());
        }
        httpClientComponent.close();
        return "elasticsearch rest client preform request fail!";
    }

    /**
     * 构建对Elasticsearch的异步请求
     *
     * @return String
     */
    @Override
    public String executeRequestAsync() {

        // restful 风格的请求
        Request request = new Request("GET", "/");
        try {

            /**
             * 在异步请求处理后,
             * 如果请求处理成功, 则调用ResponseListener类中的onSuccess方法处理相关逻辑
             * 如果请求处理失败, 则调用ResponseListener类中的onFailure方法处理相关逻辑
             */
            httpClientComponent.restClient.performRequestAsync(request, new ResponseListener() {

                /**
                 * 请求成功
                 * @param response Response
                 */
                @Override
                public void onSuccess(Response response) {
                    log.info("preform elasticsearch request async success!");
                    log.info("the response is : " + response.toString());
                }

                /**
                 * 请求失败
                 * @param e Exception
                 */
                @Override
                public void onFailure(Exception e) {
                    log.error("perform elasticsearch request async fail!");
                }
            });
        } catch (Exception e) {
            log.error("elasticsearch rest client preform request fail! error message is : " + e.getMessage());
        }
        httpClientComponent.close();
        return "elasticsearch rest client preform request fail!";
    }

    /**
     * Request还有一些可选的请求构建选项, 通过使用RequestOptions实现
     * 同时RequestOptions类中保存的请求, 可以在同一应用程序的多个请求之间共享,
     * 因此可以创建一个单例, 然后在所有请求线程之间共享公共配置
     *
     * @return String
     */
    @Override
    public String executeRequestWithRequestOptions() {
        Request request = new Request("GET", "/");
        RequestOptions.Builder builder = REQUEST_OPTIONS.toBuilder();
        builder.addHeader("title", "you are my dear");
        request.setOptions(REQUEST_OPTIONS);
        try {
            Response response = httpClientComponent.restClient.performRequest(request);
            return response.toString();
        } catch (Exception e) {
            log.error("elasticsearch rest client preform request fail! error message is : " + e.getMessage());
        }
        httpClientComponent.close();
        return "elasticsearch rest client preform request fail!";
    }

    /**
     * Elasticsearch多并行异步处理操作
     *
     * @param documents HttpEntity[]
     */
    @Override
    public void multiDocumentProcess(HttpEntity[] documents) {
        final CountDownLatch countDownLatch = new CountDownLatch(documents.length);
        for (int i = 0; i < documents.length; i++) {
            Request request = new Request("GET", "/");
            // 假设documents存储在HttpEntity数组中
            request.setEntity(documents[i]);
            httpClientComponent.restClient.performRequestAsync(request, new ResponseListener() {
                @Override
                public void onSuccess(Response response) {
                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Exception e) {
                    countDownLatch.countDown();

                }
            });
        }

        // 等待搜索异步请求执行完成
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
