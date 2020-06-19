package com.kapcb.ccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <a>Title:SpringbootKapcbMybatisApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/19 14:16
 */
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
@SpringBootApplication
public class SpringbootKapcbMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbMybatisApplication.class, args);

    }
}
