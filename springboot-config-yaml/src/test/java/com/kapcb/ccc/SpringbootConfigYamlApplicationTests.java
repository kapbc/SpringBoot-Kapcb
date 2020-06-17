package com.kapcb.ccc;

import com.kapcb.ccc.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @SpringBootTest：声明这是 SpringBoot单元测试
 * @RunWith(SpringRunner.class)：声明使用SpringRunner.class使用Spring的驱动器来跑，而不是使用原来的junit
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootConfigYamlApplicationTests {

    @Autowired
    private Person person;

    @Test
    public void testSpringBootConfigureYaml(){
        System.out.println(person);
    }

}
