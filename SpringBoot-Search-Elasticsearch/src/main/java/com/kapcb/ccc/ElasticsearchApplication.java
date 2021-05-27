package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Elasticsearch Application <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/27 21:47
 */
@ComponentScan(value = {"com.kapcb.ccc"})
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ElasticsearchApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}