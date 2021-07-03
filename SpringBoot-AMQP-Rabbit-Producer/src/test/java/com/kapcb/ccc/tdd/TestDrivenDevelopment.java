package com.kapcb.ccc.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 19:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDrivenDevelopment {

    @Value("${rabbit.mq.direct.exchange.one}")
    private String directExchangeOne;

    @Value(value = "${rabbit.mq.direct.routing.key.one}")
    private String directRoutingKeyOne;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        System.out.println("directExchangeOne = " + directExchangeOne);
        System.out.println("directRoutingKeyOne = " + directRoutingKeyOne);
        Map<String, Object> message = new HashMap<>(4);
        message.put("author", "kapcb");
        message.put("message", "Hello, RabbitMQ!");
        rabbitTemplate.convertSendAndReceive(directExchangeOne, directRoutingKeyOne, message);
    }
}
