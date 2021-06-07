package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: WebSocketApplication </a>
 * <a>Author: Kapcb <a>
 * <a>Description: WebSocket Application <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/5 18:03
 */
@SpringBootApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(WebSocketApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}