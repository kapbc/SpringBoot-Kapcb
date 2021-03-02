package com.kapcb.ccc.service;

import org.springframework.amqp.rabbit.connection.CorrelationData;

import java.util.Map;

/**
 * <a>Title: IRabbitSendService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 11:57
 */
public interface IRabbitSendService {

    /**
     * send direct message
     *
     * @param exchange   String
     * @param routingKey String
     * @param message    String
     * @return boolean
     */
    boolean sendDirectMessage(String exchange, String routingKey, Object message);

    /**
     * send direct message with correlation
     *
     * @param exchange        String
     * @param routingKey      String
     * @param message         String
     * @param correlationData CorrelationData
     * @return boolean
     */
    boolean sendDirectMessage(String exchange, String routingKey, Map<String, Object> message, CorrelationData correlationData);

    /**
     * send fanout message
     *
     * @param exchange   String
     * @param routingKey String
     * @param message    String
     * @return boolean
     */
    boolean sendFanoutMessage(String exchange, String routingKey, Object message);

    /**
     * send fanout message with correlation
     *
     * @param exchange        String
     * @param routingKey      String
     * @param message         String
     * @param correlationData CorrelationData
     * @return boolean
     */
    boolean sendFanoutMessage(String exchange, String routingKey, Object message, CorrelationData correlationData);

    /**
     * send topic message
     *
     * @param exchange   String
     * @param routingKey String
     * @param message    String
     * @return boolean
     */
    boolean sendTopicMessage(String exchange, String routingKey, Object message);

    /**
     * send topic message correlation
     *
     * @param exchange        String
     * @param routingKey      String
     * @param message         String
     * @param correlationData CorrelationData
     * @return boolean
     */
    boolean sendTopicMessage(String exchange, String routingKey, Object message, CorrelationData correlationData);
}
