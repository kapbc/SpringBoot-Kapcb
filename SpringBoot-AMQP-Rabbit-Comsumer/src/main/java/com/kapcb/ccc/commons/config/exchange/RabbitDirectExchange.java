package com.kapcb.ccc.commons.config.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: DirectExchangeConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 13:30
 */
@Slf4j
@Configuration
public class RabbitDirectExchange {

    @Bean(value = "directExchangeOne")
    public org.springframework.amqp.core.DirectExchange directExchangeOne() {
        log.info("begin to create rabbit exchange bean of directExchangeOne...");
        return new org.springframework.amqp.core.DirectExchange("directExchangeOne", true, false);
    }

    @Bean(value = "directExchangeTwo")
    public org.springframework.amqp.core.DirectExchange directExchangeTwo() {
        log.info("begin to create rabbit exchange bean of directExchangeTwo...");
        return new org.springframework.amqp.core.DirectExchange("directExchangeTwo", true, false);
    }

    @Bean(value = "directQueueOne")
    public Queue directQueueOne() {
        log.info("begin to create rabbit queue bean of directQueueOne...");
        return new Queue("directQueueOne", true, false, false);
    }

    @Bean(value = "directQueueTwo")
    public Queue directQueueTwo() {
        log.info("begin to create rabbit queue bean of directQueueTwo...");
        return new Queue("directQueueTwo", true, false, false);
    }

    @Bean
    public Binding directQueueBingingOne(@Qualifier(value = "directQueueOne") Queue directQueueOne, @Qualifier(value = "directExchangeOne") org.springframework.amqp.core.DirectExchange directExchangeOne) {
        log.info("begin to binding directQueueOne to  directExchangeOne...");
        return BindingBuilder.bind(directQueueOne).to(directExchangeOne).with("rabbit.direct.one");
    }

    @Bean
    public Binding directQueueBindingTwo(@Qualifier(value = "directQueueTwo") Queue directQueueTwo, @Qualifier(value = "directExchangeTwo") org.springframework.amqp.core.DirectExchange directExchangeTwo) {
        log.info("begin to binding directQueueTwo to directExchangeTwo...");
        return BindingBuilder.bind(directQueueTwo).to(directExchangeTwo).with("rabbit.direct.two");
    }

}
