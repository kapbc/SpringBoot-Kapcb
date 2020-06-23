package com.kapcb.ccc.controller;

import com.kapcb.ccc.exception.NotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title:ExceptionHandler</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * 异常处理器
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/22 17:45
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static final int INITIAL_CAPACITY = 2;

    /**
     * @param e Exception
     * @return Map<String, Object>
     * @ResponseBody：返回json数据
     * @ExceptionHandler(NotExistException.class)：SpringMVC的自定义异常拦截，出现这个异常就会调用这个方法
     */
/*    @ResponseBody
    @ExceptionHandler(NotExistException.class)
    public Map<String, Object> handlerException(Exception e) {
        Map<String, Object> map = new HashMap<>(INITIAL_CAPACITY);
        map.put("code","UserNameNotExist");
        map.put("message",e.getMessage());
        return map;
    }*/
    @ExceptionHandler(NotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(INITIAL_CAPACITY);

        /**
         * SpringMVC 获取错误状态码的代码，所以我们在 request中设置我们的错误状态码即可被SpringMVC获取到
         * 不设置错误状态码默认是200，就不会进入到我们自定义的错误状态码的解析
         * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "UserNameNotExist");
        map.put("message", e.getMessage());

        //将自定义的信息存放在 request 域中，在后面的MyErrorAttributes获取并输出到异常页面
        request.setAttribute("etx", map);

        //转发到 /error 请求，再通过 errorController进行自适应处理
        return "forward:/error";
    }

}
