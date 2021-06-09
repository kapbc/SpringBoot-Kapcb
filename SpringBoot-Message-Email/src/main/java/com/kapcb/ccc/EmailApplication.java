package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: EmailApplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * https://gitee.com/hf-hf/mail-micro-service
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/9 23:03
 */
@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(EmailApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}