package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.exception.RabbitSendException;
import com.kapcb.ccc.commons.utils.JsonUtil;
import com.kapcb.ccc.commons.utils.JsonUtil.JsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <a>Title: ExceptionController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 12:29
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {RabbitSendException.class})
    public String handlerRabbitSendException(RabbitSendException e) {
        log.info("handlerRabbitSendException the error message is : " + e.getMessage());
        return new JsonBuilder()
                .put("message", "Rabbit Send Message Error!")
                .put("code", "201")
                .put("data", "")
                .builder();
    }
}
