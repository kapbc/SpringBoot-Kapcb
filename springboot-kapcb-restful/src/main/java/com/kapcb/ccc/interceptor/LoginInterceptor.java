package com.kapcb.ccc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title:LoginInterceptor</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/22 17:19
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object users = request.getSession().getAttribute("users");
        if (users == null) {
            request.setAttribute("msg", "请登陆后访问！");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
