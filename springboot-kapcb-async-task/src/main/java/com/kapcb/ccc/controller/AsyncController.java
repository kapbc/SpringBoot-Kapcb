package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:AsyncController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 22:46
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping(path = "hello")
    public String hello() {
        this.asyncService.hello();
        return "success";
    }
}
