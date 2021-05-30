package com.kapcb.ccc.service;

import org.apache.http.HttpEntity;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/28 22:12
 */
public interface ElasticsearchService {

    String executeRequest();

    String executeRequestAsync();

    String executeRequestWithRequestOptions();

    void multiDocumentProcess(HttpEntity[] documents);
}
