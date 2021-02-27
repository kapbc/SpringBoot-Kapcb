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

    @Override
    public boolean sendDirectMessage(String exchange, String routingKey, Object message) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            return true;
        } catch (Exception e) {
            log.error("send direct message error, the exception message is : " + e.getMessage());
        }
        return false;
    }

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