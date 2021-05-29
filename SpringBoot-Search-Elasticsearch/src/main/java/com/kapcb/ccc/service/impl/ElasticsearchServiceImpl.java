package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.component.HttpClientComponent;
import com.kapcb.ccc.service.ElasticsearchService;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
