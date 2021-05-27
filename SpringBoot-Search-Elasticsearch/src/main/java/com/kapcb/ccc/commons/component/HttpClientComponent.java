package com.kapcb.ccc.commons.component;

import com.kapcb.ccc.commons.properties.ElasticsearchProperties;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.NodeSelector;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Http Client Component <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/27 22:17
 */
@Component
//@ConditionalOnProperty()
public class HttpClientComponent {

    private static final Logger log = LoggerFactory.getLogger(HttpClientComponent.class);

    private RestClient restClient;

    @Resource
    private ElasticsearchProperties elasticsearchProperties;

    @PostConstruct
    public void init() {

        RestClientBuilder builder = RestClient.builder(new HttpHost(elasticsearchProperties.getHost(), elasticsearchProperties.getPort(), elasticsearchProperties.getScheme()));

        // 请求头配置方法, 设置每个请求头默认需要发送的请求头配置
        Header[] headers = {new BasicHeader("header", "kapcb")};
        builder.setDefaultHeaders(headers);

        // 配置监听器, 该监听器在每次节点初始化失败时都会收到通知, 在启用嗅探器时在内部使用
        builder.setFailureListener(new RestClient.FailureListener(){
            @Override
            public void onFailure(Node node) {
                super.onFailure(node);
            }
        });

        // 配置节点选择器
        builder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);

        // 设置超时时间
        builder.setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setSocketTimeout(10000));

        this.restClient = builder.build();

        log.info("elasticsearch rest client init success!");
    }

    public void close() {
        try {
            this.restClient.close();
        } catch (IOException e) {
            log.error("elasticsearch rest client close fail! error message is : " + e.getMessage());
        }
    }
}