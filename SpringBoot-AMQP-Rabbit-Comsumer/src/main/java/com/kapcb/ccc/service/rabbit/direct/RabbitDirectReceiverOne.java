package com.kapcb.ccc.service.rabbit.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQBasicProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * <a>Title: RabbitDirectRecevier </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 13:34
 */
@Slf4j
@Component
public class RabbitDirectReceiverOne {

    @RabbitHandler
    @RabbitListener(queues = "")
    public void process(Map<String, Object> message) {
        log.info("the message from rabbit direct is : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "")
    public void process(@Payload String jsonString, Channel channel, @Headers Map<String, Object> headers) {
        log.info("the message body is : " + jsonString);
        log.info("the channel is : " + channel);
        log.info("the headers is : " + headers);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
