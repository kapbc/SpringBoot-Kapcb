package com.kapcb.ccc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <a>Title:SpringbootKapcbDubboProviderApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:55
 */
@EnableDubbo
@SpringBootApplication
public class SpringbootKapcbDubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbDubboProviderApplication.class, args);
    }
}
