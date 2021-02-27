package com.kapcb.ccc.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.concurrent.SettableListenableFuture;

/**
 * <a>Title: RabbitConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 11:54
 */
@Slf4j
@Configuration
public class RabbitConfiguration {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 生产者推送消息的消息确认调用回调函数已经完毕
     * <p>
     * 推送消息存在四种情况：
     * ①消息推送到server，但是在server里找不到交换机
     * ②消息推送到server，找到交换机了，但是没找到队列
     * ③消息推送到sever，交换机和队列啥都没找到
     * ④消息推送成功
     *
     * @param connectionFactory ConnectionFactory
     * @return RabbitTemplate
     */
    @Bean(value = "rabbitTemplate")
    @Scope(value = "pro")
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        /**
         * 设置开启Mandatory才能触发回调函数，无论推送消息结果如何都强制调用回调函数
         */
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("RabbitConfirmCallback        correlationData : " + correlationData);
            log.info("RabbitConfirmCallback        ack : " + ack);
            log.info("RabbitConfirmCallback        cause : " + cause);

            if (ack) {
                if (correlationData!=null){
                    String id = correlationData.getId();
                    SettableListenableFuture<CorrelationData.Confirm> future = correlationData.getFuture();
                    Message returnedMessage = correlationData.getReturnedMessage();
                    Class<? extends CorrelationData> aClass = correlationData.getClass();
                    log.info("the correlationData's id is : " + id);
                    log.info("the correlationData's future is : " + future);
                    log.info("the correlationData's returnedMessage is : " + returnedMessage);
                    log.info("the correlationData's aClass is : " + aClass);
                }
            } else {
                /**
                 * 失败进行具体的后续处理：重试 或者补偿等手段
                 */
                log.info("send message to rabbitmq exchange error!");
            }
        });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("RabbitReturnCallback        message : " + message);
            log.info("RabbitReturnCallback        replyCode : " + replyCode);
            log.info("RabbitReturnCallback        replyText : " + replyText);
            log.info("RabbitReturnCallback        exchange : " + exchange);
            log.info("RabbitReturnCallback        routingKey : " + routingKey);
        });

        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
