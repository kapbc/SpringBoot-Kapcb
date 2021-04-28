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
 * @date 2020/6/25 23:32
 */
@Configuration
public class DruidConfigure {

    private static final int INITIAL_CAPACITY = 2;
    public static final String PARAM_NAME_USERNAME = "loginUsername";
    public static final String PARAM_USERNAME = "kapcb";
    public static final String PARAM_NAME_PASSWORD = "loginPassword";
    public static final String PARAM_PASSWORD = "kapcb";
    public static final String PARAM_NAME_ALLOW = "allow";
    public static final String PARAM_ALLOW_URL = "";
    public static final String PARAM_NAME_DENY = "deny";
    public static final String PARAM_DENY_IP = "192.168.17.70";

    public static final String PARAM_NAME_EXCLUSIONS = "exclusions";
    private static final String PARAM_EXCLUSIONS_URL = "*.js,*.css,/druid/*";
    private static final String COLLECTION_URL = "/";

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        initParam.put(PARAM_NAME_USERNAME, PARAM_USERNAME);
        initParam.put(PARAM_NAME_PASSWORD, PARAM_PASSWORD);
        initParam.put(PARAM_NAME_ALLOW, PARAM_ALLOW_URL);
        initParam.put(PARAM_NAME_DENY, PARAM_DENY_IP);
        registrationBean.setInitParameters(initParam);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());
        HashMap<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        initParam.put(PARAM_NAME_EXCLUSIONS, PARAM_EXCLUSIONS_URL);
        registrationBean.setInitParameters(initParam);
        registrationBean.setUrlPatterns(Arrays.asList(COLLECTION_URL));
        return registrationBean;
    }
}