package com.kapcb.ccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <a>Title:SpringbootKapcbAsyncTaskApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 22:53
 */
@EnableAsync
@SpringBootApplication
public class SpringbootKapcbAsyncTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbAsyncTaskApplication.class, args);
    }
}
