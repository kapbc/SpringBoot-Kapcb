package com.kapcb.ccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <a>Title:SpringbootKapcbRedisApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 23:06
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
public class SpringbootKapcbRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbRedisApplication.class, args);
    }
}
