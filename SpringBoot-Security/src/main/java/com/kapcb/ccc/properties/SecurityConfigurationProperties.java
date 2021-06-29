package com.kapcb.ccc.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: SecurityConfigurationProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/29 22:05
 */
@Data
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "kapcb.security", ignoreInvalidFields = true)
public class SecurityConfigurationProperties {

    private String username;

    private String password;
}
