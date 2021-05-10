package com.kapcb.ccc;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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
public class AsyncSynchronizationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AsyncSynchronizationApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
