package com.kapcb.ccc.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <a>Title:LoginInterceptor</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 11:43
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object users = request.getSession().getAttribute("users");
        if (users == null) {
            request.setAttribute("msg", "请登陆后在访问！");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        } else {
            return true;
        }

    }
}
