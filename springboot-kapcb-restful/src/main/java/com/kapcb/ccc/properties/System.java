package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <a>Title:System</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/22 16:23
 */
@Data
@Component
@ConfigurationProperties(prefix = "system")
public class System implements Serializable {
    private static final long serialVersionUID = 1752003042278278758L;

    private String username;
    private String password;
}
