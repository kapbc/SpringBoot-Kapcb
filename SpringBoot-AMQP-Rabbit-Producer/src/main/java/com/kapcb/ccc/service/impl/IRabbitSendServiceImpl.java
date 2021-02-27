package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IRabbitSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Correlation;
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
        return false;
    }

    @Override
    public boolean sendDirectMessage(String exchange, String routingKey, Object message, Correlation correlation) {
        return false;
    }

    @Override
    public boolean sendFanoutMessage(String exchange, String routingKey, Object message) {
        return false;
    }

    @Override
    public boolean sendFanoutMessage(String exchange, String routingKey, Object message, Correlation correlation) {
        return false;
    }

    @Override
    public boolean sendTopicMessage(String exchange, String routingKey, Object message) {
        return false;
    }

    @Override
    public boolean sendTopicMessage(String exchange, String routingKey, Object message, Correlation correlation) {
        return false;
    }
}
