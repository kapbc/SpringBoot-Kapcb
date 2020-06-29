package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <a>Title:RouteController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/29 22:15
 */
@Controller
public class RouteController {
    private final String PREFIX = "pages/";

    /**
     * 首页
     *
     * @return welcome
     */
    @GetMapping(path = "/")
    public String index() {
        return "welcome";
    }

    /**
     * 登录页
     *
     * @return login
     */
    @GetMapping(path = "/login")
    public String login() {
        return PREFIX + "login";
    }

    /**
     * level1映射
     *
     * @param level level
     * @return String
     */
    @GetMapping(path = "level1/{level}")
    public String level1(@PathVariable String level) {
        return PREFIX + "level1/" + level;
    }

    /**
     * level2映射
     *
     * @param level level
     * @return String
     */
    @GetMapping(path = "level2/{level}")
    public String level2(@PathVariable String level) {
        return PREFIX + "level2/" + level;
    }

    /**
     * level3映射
     *
     * @param level level
     * @return String
     */
    @GetMapping(path = "level3/{level}")
    public String level3(@PathVariable String level) {
        return PREFIX + "level3/" + level;
    }
}
