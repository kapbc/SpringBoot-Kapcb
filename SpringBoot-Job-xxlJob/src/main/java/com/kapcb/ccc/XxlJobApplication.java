package com.kapcb.ccc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: XxlJobApplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: XxlJob Application <a>
 *
 * https://www.cnblogs.com/ysocean/p/10541151.html
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 13:01
 */
@SpringBootApplication
public class XxlJobApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(XxlJobApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}