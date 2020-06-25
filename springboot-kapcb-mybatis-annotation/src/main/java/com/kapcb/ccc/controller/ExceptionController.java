package com.kapcb.ccc.controller;

import com.kapcb.ccc.exception.SystemException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:ExceptionController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 11:58
 */
@RestController
public class ExceptionController {

    @Value("${system.login.username}")
    private String username;

    @RequestMapping(path = "hello")
    public String testException(@RequestParam String aaa){
        if (!username.equals(aaa)) {
            return "Hello" + aaa;
        } else {
            throw new SystemException();
        }
    }
}
