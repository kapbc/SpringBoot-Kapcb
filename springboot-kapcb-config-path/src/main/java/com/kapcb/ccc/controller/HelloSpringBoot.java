package com.kapcb.ccc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:HelloSpringBoot</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/18 18:53
 */
@RestController
public class HelloSpringBoot {

    @RequestMapping(path = "hello")
    public String hello(){
        return "hello!";
    }
}
