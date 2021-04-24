package com.kapcb.ccc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: GatewayApplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: Gateway Application <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 13:09
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}