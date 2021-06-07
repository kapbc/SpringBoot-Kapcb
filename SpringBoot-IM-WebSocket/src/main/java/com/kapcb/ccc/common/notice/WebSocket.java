package com.kapcb.ccc.common.notice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a>Title: WebSocket </a>
 * <a>Author: Mike Chen <a>
 * <a>Description:  <a>
 *
 * @author Mike Chen
 * @date 2021/6/4-11:36
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{username}")
public class WebSocket {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static AtomicInteger onlineCount = new AtomicInteger(0);

    private static Map<String, WebSocket> clients = new ConcurrentHashMap<>(16);

    private Session session;

    private String username;

    @OnOpen
    @SneakyThrows(value = {Exception.class})
    public void onOpen(@PathParam("username") String username, javax.websocket.Session session) {
        onlineCount.incrementAndGet();
        log.info("new connection, current online count is : " + onlineCount.get());
        this.username = username;
        this.session = session;
        // messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
        Map<String, Object> onlineMessageMap = new HashMap<>(6);
        // 先给所有人发送通知，说我上线了
        onlineMessageMap.put("messageType", 1);
        onlineMessageMap.put("username", username);
        this.sendMessageAll(OBJECT_MAPPER.writeValueAsString(onlineMessageMap), username);

        // 把自己的信息放入map中去
        clients.put(username, this);
        // 给自己发一条消息，说明现在还有谁在线
        Map<String, Object> sendMySelfMessageMap = new HashMap<>(4);
        sendMySelfMessageMap.put("messageType", 3);
        Set<String> set = clients.keySet();
        // 移除掉自己
        sendMySelfMessageMap.put("onlineUsers", set);
        sendMessageTo(OBJECT_MAPPER.writeValueAsString(sendMySelfMessageMap), username);
    }

    @OnClose
    @SneakyThrows(value = {Exception.class})
    public void onClose() {
        log.info("disconnection one");
        onlineCount.decrementAndGet();
        clients.remove(username);
        Map<String, Object> offlineMessageMap = new HashMap<>(6);
        offlineMessageMap.put("messageType", 2);
        offlineMessageMap.put("username", username);
        offlineMessageMap.put("onlineUsers", clients.keySet());
        sendMessageAll(OBJECT_MAPPER.writeValueAsString(offlineMessageMap), username);
    }

    @OnError
    @SneakyThrows(value = {Exception.class})
    public void onError(Session session, Throwable throwable) {
        log.error("server error, error message is : " + throwable.getMessage());
    }

    @OnMessage
    @SneakyThrows(value = {Exception.class})
    public void onMessage(String message, Session session) {
        log.info("message comes from client : " + message + " client id is : " + session.getId());
        JsonNode jsonNode = OBJECT_MAPPER.readTree(message);
        String textMessage = jsonNode.get("message").asText();
        String username = jsonNode.get("username").asText();
        String to = jsonNode.get("to").asText();
        // 如果不是发给所有人，那么就发给一个人
        // messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
        Map<String, Object> messageMap = new HashMap<>(4);
        messageMap.put("messageType", 4);
        messageMap.put("textMessage", textMessage);
        messageMap.put("fromusername", username);
        if (Objects.equals("All", to)) {
            messageMap.put("tousername", "所有人");
            sendMessageAll(OBJECT_MAPPER.writeValueAsString(messageMap), username);
        } else {
            messageMap.put("tousername", to);
            sendMessageTo(OBJECT_MAPPER.writeValueAsString(messageMap), to);
        }
    }

    @SneakyThrows(value = {Exception.class})
    public void sendMessageTo(String message, String username) {
        for (WebSocket value : clients.values()) {
            if (Objects.equals(value.username, username)) {
                value.session.getAsyncRemote().sendText(message);
                break;
            }
        }
    }

    @SneakyThrows(value = {Exception.class})
    public void sendMessageAll(String message, String fromUserName) {
        for (WebSocket value : clients.values()) {
            value.session.getAsyncRemote().sendText(message);
        }
    }
}
