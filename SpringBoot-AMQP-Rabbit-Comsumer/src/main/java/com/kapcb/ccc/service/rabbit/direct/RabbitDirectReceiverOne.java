package com.kapcb.ccc.service.rabbit.direct;

import com.kapcb.ccc.commons.utils.JsonUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * <a>Title: RabbitDirectReceiverOne </a>
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
    @RabbitListener(queues = "directQueueOne")
    public void process(Message message, Channel channel) throws IOException {
        log.info("the message from rabbit direct is : " + new String(message.getBody()));
        try {
            Map<String, Object> messageMap = JsonUtil.convertByteArrayToObject(message.getBody(), Map.class);
            log.info("the message object is : " + messageMap);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("the consumer have received the message!");
        } catch (IOException e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            log.info("the consumer received the message fail");
        }
    }

//    @RabbitHandler
//    @RabbitListener(queues = "")
//    public void process(Message message,Channel channel) {
//
//    }
}
