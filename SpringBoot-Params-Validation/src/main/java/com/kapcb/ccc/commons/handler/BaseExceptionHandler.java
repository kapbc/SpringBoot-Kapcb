package com.kapcb.ccc.commons.handler;

import com.kapcb.ccc.commons.entity.ResultInfo;
import com.kapcb.ccc.commons.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * <a>Title: GlobalExceptionHandler </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 14:23
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerException(Exception e) {
        log.error("handler exception in BaseExceptionHandler, the error message is ： " + e.getMessage());
        return new ResultInfo
                .Builder()
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data("")
                .build();
    }

    @ExceptionHandler(value = SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerSystemException(SystemException e) {
        log.error("handler SystemException in BaseExceptionHandler, the error message is ： " + e.getMessage());
        return new ResultInfo
                .Builder()
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data("")
                .build();
    }


}
