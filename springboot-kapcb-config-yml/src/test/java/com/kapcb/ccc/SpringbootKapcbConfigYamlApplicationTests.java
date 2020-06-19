package com.kapcb.ccc;

import com.kapcb.ccc.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbConfigYamlApplicationTests {

    @Autowired
    private ApplicationContext ioc;

    @Autowired
    private Person person;

    @Test
    public void testProperties() {
        System.out.println(this.person);
    }

    @Test
    public void testIoC() {
        boolean helloService = this.ioc.containsBean("helloService");
        if (helloService) {
            System.out.println("存在使用配置文件注册的bean对象");
        } else {
            System.out.println("不存在使用配置文件注册的bean对象");
        }

        boolean helloService01 = this.ioc.containsBean("helloService01");
        if (helloService01) {
            System.out.println("存在使用@Bean注解注册的bean对象");
        } else {
            System.out.println("不存在使用@Bean注解注册的bean对象");
        }
    }
}
