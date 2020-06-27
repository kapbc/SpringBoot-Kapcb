package com.kapcb.ccc;

import com.kapcb.ccc.domain.Article;
import com.kapcb.ccc.repository.ArticleRepository;
import com.kapcb.ccc.service.IArticleService;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbElasticsearchApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testElasticSearch() {
        Article article = new Article();
        articleRepository.save(article);
    }

}
