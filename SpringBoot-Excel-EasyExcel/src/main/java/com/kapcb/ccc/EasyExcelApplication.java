package com.kapcb.ccc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <a>Title: EasyExcelApplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: Easy Excel Application <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/23 - 22:49
 */
@EnableAsync
@SpringBootApplication
public class EasyExcelApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(EasyExcelApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
