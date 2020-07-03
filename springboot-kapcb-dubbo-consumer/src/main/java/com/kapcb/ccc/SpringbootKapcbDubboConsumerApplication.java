package com.kapcb.ccc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <a>Title:SpringbootKapcbDubboConsumerApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 23:09
 */
@EnableDubbo
@SpringBootApplication
public class SpringbootKapcbDubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbDubboConsumerApplication.class,args);
    }
}
