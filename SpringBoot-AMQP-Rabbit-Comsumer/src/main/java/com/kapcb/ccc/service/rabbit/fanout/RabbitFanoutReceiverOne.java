package com.kapcb.ccc.service.rabbit.fanout;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.commons.utils.JsonUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <a>Title: RabbitFanoutReceiver </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 13:35
 */
@Slf4j
@Component
public class RabbitFanoutReceiverOne {

    @RabbitHandler
    @RabbitListener(queues = "")
    public void fanoutMessageReceiver(Message message, Channel channel) throws IOException {
        log.info("fanout message receive the message");
        User user = JsonUtil.convertByteArrayToObject(message.getBody(), User.class);
        log.info("the message is : " + user);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            log.error("fail");
        }
    }
}
