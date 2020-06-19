package com.kapcb.ccc.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <a>Title:Person</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/19 9:48
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private String email;
    private Integer age;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
