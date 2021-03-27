package com.kapcb.ccc.controller;

import com.github.pagehelper.PageInfo;
import com.kapcb.ccc.pojo.UserPojo;
import com.kapcb.ccc.service.UserService;
import com.kapcb.ccc.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: UserController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/27 11:53
 */
@Slf4j
@RequestMapping
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping(value = "getUserList")
    public Map<String, Object> getUserList(@RequestParam("page")Integer page, @RequestParam("size")Integer size){
        log.info("the page is : "+page);
        log.info("the size is : "+size);
        PageInfo<UserPojo> userVOList = userService.getUserVOList(page, size);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("userList",userVOList);
        return resultMap;
    }
}
