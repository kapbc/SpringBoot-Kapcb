package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <a>Title:SystemProperties</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 23:29
 */
@Data
@Component
@ConfigurationProperties(prefix = "system.login")
public class SystemProperties {
    private String username;
    private String password;
}
