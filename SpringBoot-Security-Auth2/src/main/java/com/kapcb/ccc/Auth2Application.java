package com.kapcb.ccc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: Auth2Application </a>
 * <a>Author: kapcb <a>
 * <a>Description: Auth 2.0 Application <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 13:06
 */
@SpringBootApplication
public class Auth2Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Auth2Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
    
}
