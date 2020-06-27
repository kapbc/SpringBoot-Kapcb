package com.kapcb.ccc.repository;

import com.kapcb.ccc.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <a>Title:ArticleRepository</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 22:29
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
}
