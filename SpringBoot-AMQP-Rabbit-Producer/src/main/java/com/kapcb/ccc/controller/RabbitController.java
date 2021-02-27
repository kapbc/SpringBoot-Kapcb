package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.IRabbitSendService;
import com.kapcb.ccc.service.impl.IRabbitSendServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Value(value = "${}")
    private String directExchangeOne;

    @Value(value = "${}")
    private String directExchangeTwo;

    @Value(value = "${}")
    private String fanoutExchangeOne;

    @Value(value = "${}")
    private String directRoutingKeyOne;

    @Value(value = "${}")
    private String fanoutRoutingKeyOne;

    @Value(value = "${}")
    private String fanoutRoutingKeyTwo;

    @Value(value = "${}")
    private String fanoutRoutingKeyThree;

    @Value(value = "${}")
    private String topicRoutingKeyOne;

    @Value(value = "${}")
    private String topicRoutingKeyTwo;

    private final IRabbitSendService rabbitSendService;

    @Autowired
    public RabbitController(IRabbitSendServiceImpl rabbitSendService) {
        this.rabbitSendService = rabbitSendService;
    }

    @GetMapping(path = "", produces = "application/json; charset=utf-8")
    public String sendDirectMessage() {
        return "success";
    }
}
