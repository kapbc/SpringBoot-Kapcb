package com.kapcb.ccc.configure;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <a>Title:MyFirstSecurityConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/29 23:08
 */
@EnableWebSecurity
public class MyFirstSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //开启自动配置的登录功能
        //formLogin()默认发送 /login请求来到登录页
        //重定向到/login?error 表示登录失败
        //
        http.formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("kapcb").password("kapcb").roles("vip1", "vip2")
                .and()
                .withUser("ccc").password("kapcb").roles("vip2", "vip3")
                .and()
                .withUser("zhangsan").password("kapcb").roles("vip1", "vip3");
    }


}
