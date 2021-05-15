package com.kapcb.ccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Async Synchronization Application <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/10 22:16
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
@ComponentScan(basePackages = {"com.kapcb.ccc.mapper"})
public class AsyncSynchronizationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AsyncSynchronizationApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
