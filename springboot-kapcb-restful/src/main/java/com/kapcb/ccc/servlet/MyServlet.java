package com.kapcb.ccc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <a>Title:MyServlet</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * 声明一个Servlet
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 21:01
 */
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 5434886955058418293L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello Servlet");
        System.out.println("Hello Servlet");
    }
}
