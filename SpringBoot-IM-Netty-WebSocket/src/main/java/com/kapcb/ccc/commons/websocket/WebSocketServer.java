package com.kapcb.ccc.commons.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.OnBinary;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnError;
import org.yeauty.annotation.OnEvent;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a>Title: WebSocketServer </a>
 * <a>Author: Mike Chen <a>
 * <a>Description:  <a>
 *
 * @author Mike Chen
 * @date 2021/6/3-11:44
 */
@Slf4j
@Component
@ServerEndpoint(prefix = "ws-service")
public class WebSocketServer {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static AtomicInteger onlineUserCount = new AtomicInteger(0);

//    保存长连接信息
//    private static CopyOnWriteArrayList<WebSocketServer> webSocketServerSet = new CopyOnWriteArrayList<>();

    @OnOpen
    @SneakyThrows(value = {Exception.class})
    public void onOpen(Session session, HttpHeaders httpHeaders, ParameterMap parameterMap) {
        onlineUserCount.incrementAndGet();
        log.info("new connection......");
        String paramValue = parameterMap.getParameter("paramKey");
        log.info("param value is : " + paramValue);
        session.sendText("Hello, I'm Mike!");
    }

    @OnClose
    @SneakyThrows(value = {Exception.class})
    public void onClose(Session session) {
        onlineUserCount.decrementAndGet();
        log.info("one connection closed......");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.info("web socket meet error, error message is : " + throwable.getMessage());
    }

    /**
     * 服务端发送消息给客户端
     *
     * @param session Session
     * @param message String
     */
    @OnMessage
    @SneakyThrows(value = {Exception.class})
    public void onMessage(@NonNull Session session, @NonNull String message) {
        log.info("the session is : " + session.toString());
        log.info("the message is : " + message);
        String chatContent = OBJECT_MAPPER.readTree(message).get("chatContent").asText();
        log.info("the chat content is : " + chatContent);
        session.sendText(chatContent);
        log.info("send message success!");
    }

    @OnBinary
    public void onBinary(@NonNull Session session, @NonNull byte[] bytes) {
        for (byte aByte : bytes) {
            log.info("the binary bytes is : " + aByte);
        }
        session.sendBinary(bytes);
        log.info("send message success!");
    }

    @OnEvent
    public void onEvent(@NonNull Session session, @NonNull Object event) {
        if (event instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) event;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    log.info("read idle");
                    break;
                case WRITER_IDLE:
                    log.info("write idle");
                    break;
                case ALL_IDLE:
                    log.info("all idle");
                    break;
                default:
                    break;
            }
        }
    }
}
