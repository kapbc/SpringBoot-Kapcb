package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * <a>Title:BookService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 22:08
 */
@Service
public class BookService {

    /**
     * 监听kapcb.news消息
     *
     * @param book Book
     */
    @RabbitListener(queues = "kapcb.news")
    public void receive(Book book) {
        System.out.println("收到消息" + book);
    }

    /**
     * 获取消息头
     *
     * @param message org.springframework.amqp.core.Message
     */
    @RabbitListener(queues = "kapcb.dept")
    public void receiveMessage(Message message) {
        byte[] body = message.getBody();
        MessageProperties messageProperties = message.getMessageProperties();
        System.out.println("body = " + body);
        System.out.println("messageProperties = " + messageProperties);
    }

}
