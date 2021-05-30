package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.component.HttpClientComponent;
import com.kapcb.ccc.service.ElasticsearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Elasticsearch Controller <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/27 22:35
 */
@RestController
@RequestMapping("elasticsearch")
public class ElasticsearchController {

    @Resource
    private HttpClientComponent httpClientComponent;

    @Resource
    private ElasticsearchService elasticsearchService;

    @GetMapping(value = "init")
    public String init() {
        httpClientComponent.init();
        return "init elasticsearch rest client success!";
    }

    @GetMapping(value = "parseElasticsearchResponse")
    public String parseElasticsearchResponse() {
        return elasticsearchService.parseElasticsearchResponse();
    }

}