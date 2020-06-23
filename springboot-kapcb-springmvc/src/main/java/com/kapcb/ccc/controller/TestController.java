package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * <a>Title:TestController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/21 11:14
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(path = "hello")
    public String hello() {
        return "Hello Kapcb!";
    }

    @RequestMapping(path = "success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好，Kapcb！");
        map.put("demo", "<h1>你好，Kapcb！</h1>");
        map.put("users", Arrays.asList("kapcb", "eirc", "ccc"));
        return "success";
    }
}
