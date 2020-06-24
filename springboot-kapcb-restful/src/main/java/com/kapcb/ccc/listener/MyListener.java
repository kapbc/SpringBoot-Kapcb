package com.kapcb.ccc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <a>Title:MyListener</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 21:33
 */
public class MyListener implements ServletContextListener {

    /**
     * 监听 Servlet 容器初始化
     *
     * @param sce ServletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized(初始化方法)...监听到web应用启动");
    }

    /**
     * 监听 Servlet 容器销毁
     *
     * @param sce ServletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed(销毁方法)...监听到当前web应用销毁");
    }
}
