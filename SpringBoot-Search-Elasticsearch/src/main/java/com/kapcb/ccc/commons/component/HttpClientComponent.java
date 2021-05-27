package com.kapcb.ccc.commons.component;

import com.kapcb.ccc.commons.properties.ElasticsearchProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init(ElasticsearchProperties elasticsearchProperties) {
        this.restClient = RestClient.builder(new HttpHost(elasticsearchProperties.getHost(), elasticsearchProperties.getPort(), elasticsearchProperties.getScheme())).build();
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