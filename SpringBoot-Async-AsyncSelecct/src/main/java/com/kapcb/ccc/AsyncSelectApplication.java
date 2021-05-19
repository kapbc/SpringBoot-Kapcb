package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AsyncSelectApplication <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/18 22:08
 */
@SpringBootApplication
public class AsyncSelectApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AsyncSelectApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
