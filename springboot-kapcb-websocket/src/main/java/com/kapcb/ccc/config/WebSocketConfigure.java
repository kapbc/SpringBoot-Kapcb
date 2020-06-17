package com.kapcb.ccc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.AbstractWebSocketClient;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * <a>Title:WebSocketConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * webSocket配置类
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/14 21:27
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigure implements WebSocketMessageBrokerConfigurer {

    /**
     * @EnableWebSocketMessageBroker注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思
     * registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL
     * stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();这一行代码用来注册STOMP协议节点，同时指定使用SockJS协议。
     *
     * @param stompEndpointRegistry StompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointSang").withSockJS();
    }

    /**
     * configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
     * @param messageBrokerRegistry MessageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        messageBrokerRegistry.enableSimpleBroker("/topic");
    }
}
