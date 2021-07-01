package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: WebFluxApplication </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/23 14:29
 */
@SpringBootApplication
public class WebFluxApplication {
    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .sources(WebFluxApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}