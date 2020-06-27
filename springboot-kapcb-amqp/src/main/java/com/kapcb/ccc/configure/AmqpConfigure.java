package com.kapcb.ccc.configure;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title:AmqpConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 19:23
 */
@Configuration
public class AmqpConfigure {

    /**
     * 自定义json格式消息转换
     * org.springframework.amqp.support.converter.MessageConverter
     * @return MessageConverter
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
