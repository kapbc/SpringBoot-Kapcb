package com.kapcb.ccc.configure;

import com.kapcb.ccc.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title:MyFirstConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/19 10:10
 */
@Configuration
public class MyFirstConfigure {

    @Bean
    public HelloService helloService01(){
        System.out.println("配置类MyFirstConfigure使用@Bean注解的方式为Spring容器中添加了组件");
        return new HelloService();
    }

}
