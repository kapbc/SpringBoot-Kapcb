package com.kapcb.ccc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a>Title:JdbcController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/24 10:57
 */
@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping(path = "test")
    public List<Map<String, Object>> jdbcTest(){
        List<Map<String, Object>> list = this.jdbcTemplate.queryForList("SELECT * FROM tb_user");
        List<Map<String, Object>> kapcb = list.stream().limit(3).collect(Collectors.toList());
        return kapcb;
    }

}
