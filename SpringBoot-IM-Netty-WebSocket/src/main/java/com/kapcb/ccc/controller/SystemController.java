package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: SystemController </a>
 * <a>Author: Mike Chen <a>
 * <a>Description:  <a>
 *
 * @author Mike Chen
 * @date 2021/6/3-17:58
 */
@Controller
@RequestMapping(value = "web")
public class SystemController {

    @GetMapping(value = "/socket")
    public String index() {
        return "index";
    }
}
