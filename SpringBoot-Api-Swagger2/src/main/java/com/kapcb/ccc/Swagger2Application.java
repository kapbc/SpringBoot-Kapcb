package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: Swagger2Application </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * https://blog.csdn.net/u012702547/article/details/88775298
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 14:59
 */
@SpringBootApplication
public class Swagger2Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .sources(Swagger2Application.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
