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
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * <a>Title:DruidConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 13:11
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
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), URL_MAPPING);
        HashMap<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
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
        registrationBean.setFilter(new WebStatFilter());
        HashMap<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        initParam.put(EXCLUSIONS, STATIC_RESOURCES);
        registrationBean.setUrlPatterns(Arrays.asList(URL_PATTERNS));
        registrationBean.setInitParameters(initParam);
        return registrationBean;
    }
}
