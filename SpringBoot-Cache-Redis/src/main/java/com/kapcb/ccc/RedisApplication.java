package com.kapcb.ccc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Redis Application <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/4/30 21:41
 */
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(RedisApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}