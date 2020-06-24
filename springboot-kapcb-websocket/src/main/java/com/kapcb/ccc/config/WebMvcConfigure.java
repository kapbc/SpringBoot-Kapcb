package com.kapcb.ccc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <a>Title:WebMvcConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * 路由跳转配置
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/14 22:16
 */
@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/webSocket").setViewName("/webSocket");
    }
}
