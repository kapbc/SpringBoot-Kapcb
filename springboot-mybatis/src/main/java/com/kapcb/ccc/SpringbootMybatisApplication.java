package com.kapcb.ccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <a>Title:SpringbootMybatisApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/16 8:49
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
public class SpringbootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
}
