package com.kapcb.ccc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * <a>Title:MyFilter</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 21:23
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter Process....");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
