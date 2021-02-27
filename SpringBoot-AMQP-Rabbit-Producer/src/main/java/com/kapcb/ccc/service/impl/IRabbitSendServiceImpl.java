package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IRabbitSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IRabbitSendServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 11:57
 */
@Slf4j
@Component(value = "rabbitService")
public class IRabbitSendServiceImpl implements IRabbitSendService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public IRabbitSendServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * convertSendAndReceive: 有序发送有序消费
     * convertAndSend: 无序发送无序消费
     *
     * @param exchange   String
     * @param routingKey String
     * @param message    String
     * @return boolean
     */
    @Override
    public boolean sendDirectMessage(String exchange, String routingKey, Object message) {
        try {
            rabbitTemplate.convertSendAndReceive(exchange, routingKey, message);
            return true;
        } catch (Exception e) {
            log.error("send direct message error, the exception message is : " + e.getMessage());
        }
        return false;
    }

    /**
     * 使用 convertAndSend 方法时的结果：输出时没有顺序，不需要等待，直接运行
     * 使用 convertSendAndReceive 方法时的结果：输出有顺序 只有确定消费者接收到消息，才会发送下一条信息，每条消息之间会有等待间隔时间
     *
     * @param exchange        String
     * @param routingKey      String
     * @param message         String
     * @param correlationData CorrelationData
     * @return boolean
     */
    @Override
    public boolean sendDirectMessage(String exchange, String routingKey, Object message, CorrelationData correlationData) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
        } catch (Exception e) {
            log.error("send direct message error, the exception message is : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean sendFanoutMessage(String exchange, String routingKey, Object message) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            return true;
        } catch (Exception e) {
            log.error("send fanout message error, the exception message is : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean sendFanoutMessage(String exchange, String routingKey, Object message, CorrelationData correlationData) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
        } catch (Exception e) {
            log.error("send fanout message error, the exception message is : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean sendTopicMessage(String exchange, String routingKey, Object message) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            return true;
        } catch (Exception e) {
            log.error("send topic message error, the exception message is : " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean sendTopicMessage(String exchange, String routingKey, Object message, CorrelationData correlationData) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
            return true;
        } catch (Exception e) {
            log.error("send topic message error, the exception message is : " + e.getMessage());
        }
        return false;
    }
}