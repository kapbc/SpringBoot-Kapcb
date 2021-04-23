package com.kapcb.ccc;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <a>Title:SpringbootKapcbAmqpApplication</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @EnableRabbit + @RabbitListener：监听消息队列的内容
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 18:42
 */
@EnableRabbit//开启基于注解的RabbitMQ模式
@SpringBootApplication
public class SpringbootKapcbAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbAmqpApplication.class, args);
    }

}