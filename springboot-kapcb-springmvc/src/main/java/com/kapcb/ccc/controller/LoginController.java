package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Employee;
import com.kapcb.ccc.service.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title:LoginController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/21 13:13
 */
@Controller
public class LoginController {

    private static final int INITIAL_CAPACITY = 2;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Value("${system.username}")
    private String name;
    @Value("${system.password}")
    private String pwd;

    @PostMapping(path = "login")
    public String login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password,
                        Map<String, Object> map,
                        HttpSession session) {

        if (name.equals(username) && pwd.equals(password)) {
            session.setAttribute("users",username);
            //防止表单重复提交，进行重定向
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
