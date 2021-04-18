package com.itstyle.seckill.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置首页
 */
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/index.shtml" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    }

}