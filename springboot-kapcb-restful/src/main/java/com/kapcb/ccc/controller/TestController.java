package com.kapcb.ccc.controller;

import com.kapcb.ccc.exception.NotExistException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:TestController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 13:59
 */
@RestController
public class TestController {

    @RequestMapping(path = "/hello")
    public String hello(@RequestParam(value = "username") String username) {
        if (username.equals("aaa")) {
            throw new NotExistException();
        }
        return "Hello Kapcb";
    }

}
