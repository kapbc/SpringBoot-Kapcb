package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;

/**
 * <a>Title:EmpController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 9:12
 */
@Controller
public class EmpController {


    public String list() {

        // thymeleaf 会默认进行拼串 classpath:/templates/xxxxx.html
        return "emp.list";
    }
}
