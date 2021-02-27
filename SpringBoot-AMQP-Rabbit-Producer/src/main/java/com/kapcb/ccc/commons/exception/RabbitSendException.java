package com.kapcb.ccc.commons.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: RabbitSendException </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 12:30
 */
@Slf4j
public class RabbitSendException extends Exception {

    private final String message;

    public RabbitSendException(String message) {
        log.info("RabbitSendException Constructor, the error message is : " + message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
