package com.kapcb.ccc.commons.config.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: RabbitDeadLetterExchange </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/2 21:54
 */
@Slf4j
@Configuration
public class RabbitDeadLetterExchange {

    @Bean(value = "businessExchange")
    public FanoutExchange businessExchange() {
        return new FanoutExchange("businessFanoutExchange", true, false);
    }

    @Bean(value = "businessQueueOne")
    public Queue businessQueueOne() {
        Map<String, Object> args = new HashMap<>(4);
        args.put("", "");
        args.put("", "");
        return QueueBuilder.durable("businessQueueOne").withArguments(args).build();
    }

    @Bean(value = "businessQueueTwo")
    public Queue businessQueueTwo() {
        Map<String, Object> args = new HashMap<>(4);
        args.put("", "");
        args.put("", "");
        return QueueBuilder.durable("businessQueueTwo").withArguments(args).build();
    }

    @Bean(value = "deadLetterExchange")
    public FanoutExchange deadLetterExchange() {
        return new FanoutExchange("deadLetterExchange", true, false);
    }

    @Bean(value = "deadLetterQueueOne")
    public Queue deadLetterQueueOne() {
        return new Queue("deadLetterQueueOne", true, false, false);
    }

    @Bean(value = "deadLetterQueueTwo")
    public Queue deadLetterQueueTwo() {
        return new Queue("deadLetterQueueTwo", true, false, false);
    }

    @Bean
    public Binding businessQueueBindingOne(@Qualifier(value = "businessQueueOne") Queue queue, @Qualifier("businessExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding businessQueueBindingTwo(@Qualifier(value = "businessQueueTwo") Queue queue, @Qualifier("businessExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding deadLetterQueueBindingOne(@Qualifier(value = "deadLetterQueueOne") Queue queue, @Qualifier(value = "businessExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding deadLetterQueueBindingTwo(@Qualifier(value = "deadLetterQueueTwo") Queue queue, @Qualifier(value = "deadLetterExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}