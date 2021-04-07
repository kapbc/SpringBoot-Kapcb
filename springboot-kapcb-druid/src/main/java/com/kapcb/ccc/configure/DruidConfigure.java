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
import java.util.Map;

/**
 * <a>Title:DruidConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/24 11:35
 */
@Configuration
public class DruidConfigure {

    
    private static final int INITIAL_CAPACITY = 2;
    

    /**
     * 自己在容器中创建一个数据源
     *
     * @return DataSource
     * @ConfigurationProperties(prefix = "spring.datasource"),进行数据绑定
     * 将配置文件中的数据与 DruidDataSource 中的配置属性进行映射
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myDataSource() {
        return new DruidDataSource();
    }

    
    /**
     * 配置 druid 的监控
     * 配置管理后台的servlet
     *
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        //用户名
        initParam.put("loginUsername", "kapcb");
        //密码
        initParam.put("loginPassword", "kapcb");
        //不写参数，默认运行所有访问
        initParam.put("allow", "");
        //黑名单
        initParam.put("deny", "192.168.17.70");
        registrationBean.setInitParameters(initParam);
        return registrationBean;
    }

    
    /**
     * 配置有一个监控的filter
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParam = new HashMap<>(INITIAL_CAPACITY);
        //设置不拦截的路径
        initParam.put("exclusions", "*.js,*.css,/druid/*");
        registrationBean.setInitParameters(initParam);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));

        return registrationBean;
    }
    
}
