package com.kapcb.ccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <a>Title:SpringbootKapcbScheduledTaskApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 23:04
 */
@EnableScheduling
@SpringBootApplication
public class SpringbootKapcbScheduledTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbScheduledTaskApplication.class, args);
    }
}
