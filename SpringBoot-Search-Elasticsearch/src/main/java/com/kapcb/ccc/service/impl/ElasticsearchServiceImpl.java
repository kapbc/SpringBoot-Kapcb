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

    @Override
    public String executeRequest() {
        Request request = new Request("GET", "/");
        try {
            Response response = httpClientComponent.restClient.performRequest(request);
            return response.toString();
        } catch (Exception e) {
            log.error("elasticsearch rest client preform request fail!");
        }
        httpClientComponent.close();
        return "elasticsearch rest client preform request fail!";
    }

    @Override
    public String executeRequestAsync() {
        Request request = new Request("GET", "/");
        try {
            httpClientComponent.restClient.performRequestAsync(request, new ResponseListener() {

                /**
                 * 请求成功
                 * @param response Response
                 */
                @Override
                public void onSuccess(Response response) {
                    log.info("preform elasticsearch request async success!");
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
        }
        return null;
    }
}
