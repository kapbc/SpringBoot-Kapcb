package com.kapcb.ccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: CanalApplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * https://gitee.com/hf-hf/mail-micro-service
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 9:24
 */
@SpringBootApplication
@EnableCanalClient
public class CanalApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
