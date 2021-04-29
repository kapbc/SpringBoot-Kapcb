package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Shiro Application <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/4/29 22:45
 */
@SpringBootApplication
public class ShiroApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ShiroApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
