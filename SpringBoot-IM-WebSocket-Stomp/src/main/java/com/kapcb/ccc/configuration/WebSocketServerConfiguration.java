package com.kapcb.ccc.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * <a>Title: WebSocketServerConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * webSocket配置类
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/29 22:46
 */
@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketServerConfiguration implements WebSocketMessageBrokerConfigurer {

    /**
     * EnableWebSocketMessageBroker : 该注解表示开启使用 STOMP 协议来传输基于代理的消息
     * Broker : 代理
     * registerStompEndpoints : 方法表示注册STOMP协议的节点，并指定映射的URL
     *
     * @param stompEndpointRegistry StompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        log.info("-----------begin to register stomp end point-----------");
        // 注册 STOMP 协议节点, 同时指定使用SockJS协议。
        stompEndpointRegistry.addEndpoint("/endpoint-stomp").withSockJS();
    }

    /**
     * 配置消息代理
     * configureMessageBroker : 方法用来配置消息代理，实现推送功能，这里的消息代理是/topic
     *
     * @param messageBrokerRegistry MessageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        log.info("-----------begin to configure message broker-----------");
        messageBrokerRegistry.enableSimpleBroker("/topic");
    }
}
