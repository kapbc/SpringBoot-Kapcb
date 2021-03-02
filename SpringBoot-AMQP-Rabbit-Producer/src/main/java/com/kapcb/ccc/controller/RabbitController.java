package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IRabbitSendService;
import com.kapcb.ccc.service.impl.IRabbitSendServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <a>Title: RabbitController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 11:57
 */
@Slf4j
@RestController
@RequestMapping(value = "rabbit")
public class RabbitController {

    private static final int INITIAL_CAPACITY = 4;
    private static final String MESSAGE_AUTHOR = "MessageAuthor";
    private static final String MESSAGE_DATA = "MessageData";
    private static final String MESSAGE_DATE = "MessageDate";
    private static final String SUCCESS_RETURN_VALUE = "process send message to rabbitmq success";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value(value = "${rabbit.mq.direct.exchange.one}")
    private String directExchangeOne;

    @Value(value = "${rabbit.mq.direct.exchange.two}")
    private String directExchangeTwo;

    @Value(value = "${rabbit.mq.fanout.exchange.one}")
    private String fanoutExchangeOne;

    @Value(value = "${rabbit.mq.topic.exchange.one}")
    private String topicExchangeOne;

    @Value(value = "${rabbit.mq.direct.routing.key.one}")
    private String directRoutingKeyOne;

    @Value(value = "${rabbit.mq.direct.routing.key.two}")
    private String directRoutingKeyTwo;

    @Value(value = "${rabbit.mq.topic.routing.key.one}")
    private String topicRoutingKeyOne;

    @Value(value = "${rabbit.mq.topic.routing.key.two}")
    private String topicRoutingKeyTwo;

    private final IRabbitSendService rabbitSendService;

    @Autowired
    public RabbitController(IRabbitSendServiceImpl rabbitSendService) {
        this.rabbitSendService = rabbitSendService;
    }

    @GetMapping(path = "direct/{name}", produces = "application/json; charset=utf-8")
    public String sendDirectMessage(@PathVariable(value = "name") String name) {
        log.info("the path variable name is : " + name);
        log.info("begin to process send message to direct exchange!");
        Map<String, Object> messageMap = new HashMap<>(INITIAL_CAPACITY);
        LocalDateTime currentDateTime = LocalDateTime.now();
        String currentLocalDateTime = DATE_TIME_FORMATTER.format(currentDateTime);
        messageMap.put(MESSAGE_AUTHOR, name);
        messageMap.put(MESSAGE_DATA, "Hello RabbitMQ, I'm Kapcb!");
        messageMap.put(MESSAGE_DATE, currentLocalDateTime);
        log.info("the direct messageMap is : " + messageMap);
        String messageId = UUID.randomUUID().toString();
        log.info("the randomUUID messageId is : " + messageId);
        CorrelationData correlationData = new CorrelationData(messageId);
        log.info("the correlationData is : " + correlationData);
        rabbitSendService.sendDirectMessage(directExchangeOne, directRoutingKeyOne, messageMap, correlationData);
        return SUCCESS_RETURN_VALUE;
    }

    @GetMapping(value = "fanout/{name}", produces = "application/json;charset=UTF-8")
    public String sendFanoutMessage(@PathVariable(value = "name") String name) {
        log.info("the path variable name is : " + name);
        log.info("begin to process send message to direct exchange!");
        User kapcb = new User.Builder().userId(1L).age(12).username("kapcb").build();
        log.info("the user is : " + kapcb);
        rabbitSendService.sendFanoutMessage("businessExchange", null, kapcb);
        return "success";
    }
}