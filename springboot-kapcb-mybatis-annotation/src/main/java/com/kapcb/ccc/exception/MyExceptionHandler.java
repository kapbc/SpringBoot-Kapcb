package com.kapcb.ccc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title:ExceptionHandler</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 11:08
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static final int INITIAL_CAPACITY = 2;

    @ExceptionHandler(SystemException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(INITIAL_CAPACITY);

        map.put("code", "SystemException");
        map.put("message", e.getMessage());
        request.setAttribute("ext",map);
        request.setAttribute("javax.servlet.error.status_code", HttpStatus.INTERNAL_SERVER_ERROR);
        return "forward:error";
    }

}
