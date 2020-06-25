package com.kapcb.ccc.configure;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * <a>Title:MyCacheConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 18:34
 */
@Configuration
public class MyCacheConfigure {

    /**
     * 自定义keyGenerator
     * 默认不指定注册到容器中的id名为keyGenerator
     * 可进行指定，在获取的时候直接以指定名称获取即可
     *
     * @return KeyGenerator
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + "[" + Arrays.asList(objects).toString() + "]";
            }
        };
    }
}
