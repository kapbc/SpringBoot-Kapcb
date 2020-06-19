package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:HelloController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/19 9:51
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("hello")
    public String hello(){
        return "Hello" + this.person.getLastName();
    }
}
