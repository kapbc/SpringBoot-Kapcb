package com.kapcb.ccc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <a>Title:LoginController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/24 21:18
 */
@Controller
public class LoginController {

    @Value("${system.login.username}")
    private String name;
    @Value("${system.login.password}")
    private String pwd;

    @PostMapping(path = "login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (name.equals(username) && pwd.equals(password)) {
            session.setAttribute("users",username);
            return "redirect:main.html";
        } else {
            map.put("msg","用户名或密码错误，请重新输入！");
            return "login";
        }
    }
}
