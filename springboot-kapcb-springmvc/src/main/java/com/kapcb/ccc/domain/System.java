package com.kapcb.ccc.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <a>Title:System</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/22 13:21
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "system")
public class System {
    private String username;
    private String password;
}
