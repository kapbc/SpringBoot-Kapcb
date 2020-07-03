package com.kapcb.ccc.configure;

import com.sun.org.apache.bcel.internal.util.BCELifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        //默认post形式的/login代表处理登录请求
        //一旦进行定时 loginPage 那么 loginPage的post的请求就是登陆
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userLogin");

        //开启自动配置的注销功能
        //默认注销请求为/logout，同时清空session
        //注销成功会返回 /login?logout 页面
        http.logout().logoutSuccessUrl("/");

        //开启记住我
        //登录成功后将cookie发送给浏览器保存，以后登录只要带上这个cookie，只要检查就可以免登录
        //如果点击注销也会删除cookie
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("kapcb").password(new BCryptPasswordEncoder().encode("kapcb")).roles("vip1", "vip2")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("ccc").password(new BCryptPasswordEncoder().encode("kapcb")).roles("vip2","vip3")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("eirc").password(new BCryptPasswordEncoder().encode("kapcb")).roles("vip1","vip3");
    }
}
