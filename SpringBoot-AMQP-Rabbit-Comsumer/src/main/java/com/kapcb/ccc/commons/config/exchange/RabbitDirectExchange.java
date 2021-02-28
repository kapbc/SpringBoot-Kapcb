package com.kapcb.ccc.commons.config.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
@PropertySource(value = {"classpath:properties/rabbit.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8")
public class RabbitDirectExchange {

    @Value(value = "${rabbit.mq.direct.exchange.one}")
    private String directExchangeOne;

    @Value(value = "${rabbit.mq.direct.exchange.two}")
    private String directExchangeTwo;

    @Value(value = "${rabbit.mq.direct.queue.one}")
    private String directQueueOne;

    @Value(value = "${rabbit.mq.direct.queue.two}")
    private String directQueueTwo;

    @Value(value = "${rabbit.mq.direct.routing.key.one}")
    private String directRoutingKeyOne;

    @Value(value = "${rabbit.mq.direct.routing.key.two}")
    private String directRoutingKeyTwo;

    @Bean(value = "directExchangeOne")
    public DirectExchange directExchangeOne() {
        log.info("begin to create rabbit exchange bean of directExchangeOne...");
        return new DirectExchange(directExchangeOne, true, false);
    }

    @Bean(value = "directExchangeTwo")
    public DirectExchange directExchangeTwo() {
        log.info("begin to create rabbit exchange bean of directExchangeTwo...");
        return new DirectExchange(directExchangeTwo, true, false);
    }

    @Bean(value = "directQueueOne")
    public Queue directQueueOne() {
        log.info("begin to create rabbit queue bean of directQueueOne...");
        return new Queue(directQueueOne, true, false, false);
    }

    @Bean(value = "directQueueTwo")
    public Queue directQueueTwo() {
        log.info("begin to create rabbit queue bean of directQueueTwo...");
        return new Queue(directQueueTwo, true, false, false);
    }

    @Bean
    public Binding directQueueBingingOne(@Qualifier(value = "directQueueOne") Queue directQueueOne, @Qualifier(value = "directExchangeOne") org.springframework.amqp.core.DirectExchange directExchangeOne) {
        log.info("begin to binding directQueueOne to  directExchangeOne...");
        return BindingBuilder.bind(directQueueOne).to(directExchangeOne).with(directRoutingKeyOne);
    }

    @Bean
    public Binding directQueueBindingTwo(@Qualifier(value = "directQueueTwo") Queue directQueueTwo, @Qualifier(value = "directExchangeTwo") org.springframework.amqp.core.DirectExchange directExchangeTwo) {
        log.info("begin to binding directQueueTwo to directExchangeTwo...");
        return BindingBuilder.bind(directQueueTwo).to(directExchangeTwo).with(directRoutingKeyTwo);
    }

}
