package com.kapcb.ccc.controller;

import com.github.pagehelper.PageInfo;
import com.kapcb.ccc.pojo.UserPojo;
import com.kapcb.ccc.service.UserService;
import com.kapcb.ccc.service.impl.UserServiceImpl;
import com.kapcb.ccc.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getUserList")
    public Map<String, Object> getUserList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        log.info("the page is : " + page);
        log.info("the size is : " + size);
        PageInfo<UserPojo> userVOList = userService.getUserVOList(page, size);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("userList", userVOList);
        return resultMap;
    }

    @GetMapping(value = "getUserById/{id}")
    public Map<String, Object> getUserById(@PathVariable("id") Long id) {
        log.info("the id is : " + id);
        UserPojo user = userService.getUser(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("message", "success");
        resultMap.put("status", 200);
        resultMap.put("data", userVO);
        return resultMap;
    }

    @PutMapping(value = "insertUser")
    public Map<String, Object> insertUser(@RequestBody UserVO userVO) {
        log.info("the userVO is : " + userVO);
        boolean insertUser = userService.insertUser(userVO);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("message", insertUser ? "success" : "fail");
        resultMap.put("status", insertUser ? 200 : 201);
        return resultMap;
    }

    @PostMapping(value = "updateUser/{id}")
    public Map<String, Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserVO userVO) {
        log.info("the user vo is : " + userVO);
        boolean updateUser = userService.updateUser(userVO, id);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("message", updateUser ? "success" : "fail");
        resultMap.put("status", updateUser ? 200 : 201);
        return resultMap;
    }

    @DeleteMapping(value = "deleteUser/{id}")
    public Map<String, Object> deleteUser(@PathVariable("id") Long id) {
        log.info("the delete user id is : " + id);
        boolean deleteUser = userService.deleteUser(id);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("message", deleteUser ? "success" : "fail");
        resultMap.put("status", deleteUser ? 200 : 201);
        return resultMap;
    }

    @DeleteMapping(value = "deletedUser/batch/{ids}")
    public Map<String, Object> batchDeleteUser(@PathVariable("ids") String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        boolean batchDeleteUser = userService.batchDelete(idList);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("message", batchDeleteUser ? "success" : "fail");
        resultMap.put("status", batchDeleteUser ? 200 : 201);
        return resultMap;
    }

    @DeleteMapping(value = "deletedUser/logic/{ids}")
    public Map<String, Object> logicDeleteUser(@PathVariable("ids") String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        boolean logicDeleteUser = userService.logicBatchDeleteUser(idList);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("message", logicDeleteUser ? "success" : "fail");
        resultMap.put("status", logicDeleteUser ? 200 : 201);
        return resultMap;
    }
}