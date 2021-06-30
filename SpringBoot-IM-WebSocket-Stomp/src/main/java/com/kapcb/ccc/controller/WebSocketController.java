package com.kapcb.ccc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title: WebSocketController </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/29 22:46
 */
@Slf4j
@RestController
public class WebSocketController {

    /**
     * MessageMapping 注解和 RequestMapping 类似
     * SendTo注解表示当服务器有消息需要推送的时候，会对订阅了 SendTo 中路径的客户端推送消息。
     *
     * @param message String
     * @return String
     */
    @SendTo(value = "/topic/send")
    @MessageMapping(value = "/websocket")
    public String websocket(String message) {
        log.info("the receive message is : " + message);
        return "Kapcb! Awesome Man!";
    }
}
