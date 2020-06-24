package com.kapcb.ccc.configure;

import com.kapcb.ccc.filter.MyFilter;
import com.kapcb.ccc.listener.MyListener;
import com.kapcb.ccc.servlet.MyServlet;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.EventListener;

/**
 * <a>Title:ServerConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 21:03
 */
@Configuration
public class ServerConfigure {

    //注册三大组件

    /**
     * 注册 Servlet
     *
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        //自己声明的 Servlet组件
        MyServlet myServlet = new MyServlet();
        //请求的映射路径
        String url = "/myServlet";
        // 传入两个参数，理解为，请求路径对应的Servlet
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(myServlet, url);
        return registrationBean;
    }


    /**
     * 注册 Filter
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        MyFilter myFilter = new MyFilter();
        //将定义的过滤器注册进来
        registrationBean.setFilter(myFilter);
        //注册需要过滤拦截的请求路径
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    /**
     * 注册 Listener
     *
     * @return ServletListenerRegistrationBean
     */
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    /**
     * 配置嵌入式的Servlet容器
     *
     * @return WebServerFactoryCustomizer<ConfigurableWebServerFactory>
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

            //定制嵌入式的Servlet容器相关配置
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }
}
