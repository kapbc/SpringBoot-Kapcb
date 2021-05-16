package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/17 22:37
 */
@Slf4j
@RestController
@RequestMapping("/")
public class SystemController {

    private final UserService userService;

    @Autowired
    public SystemController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "userInfo")
    public void getUserList(){
        log.info("prepare to load user list");
    }
}