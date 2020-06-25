package com.kapcb.ccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <a>Title:SpringbootKapcbCacheApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 15:12
 */
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
@SpringBootApplication
@EnableCaching
public class SpringbootKapcbCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbCacheApplication.class, args);
    }
}
