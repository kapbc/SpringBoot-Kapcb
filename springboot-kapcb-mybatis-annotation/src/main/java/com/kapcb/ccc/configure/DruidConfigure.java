package com.kapcb.ccc.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title:DruidConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/24 21:19
 */
@Configuration
public class DruidConfigure {

    private static final String URL_MAPPING = "/druid/*";
    private static final String URL_PATTERNS = "/*";
    private static final String STATIC_RESOURCES = "*.js,*.css,/druid/*";
    private static final String EXCLUSIONS = "exclusions";
    private static final String LOGIN_USERNAME = "loginUsername";
    private static final String LOGIN_PASSWORD = "loginPassword";
    private static final String USERNAME = "kapcb";
    private static final String PASSWORD = "kapcb";
    private static final String ALLOW = "allow";
    private static final String ALLOW_URL = "";
    private static final String DENY = "deny";
    private static final String DENY_IP = "192.168.17.70";
    private static final int INITIAL_CAPACITY = 2;


    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), URL_MAPPING);
        Map<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        initParam.put(LOGIN_USERNAME, USERNAME);
        initParam.put(LOGIN_PASSWORD, PASSWORD);
        initParam.put(ALLOW, ALLOW_URL);
        initParam.put(DENY, DENY_IP);
        registrationBean.setInitParameters(initParam);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        Map<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        registrationBean.setFilter(new WebStatFilter());
        initParam.put(EXCLUSIONS, STATIC_RESOURCES);
        registrationBean.setUrlPatterns(Arrays.asList(URL_PATTERNS));
        registrationBean.setInitParameters(initParam);
        return registrationBean;
    }
}
