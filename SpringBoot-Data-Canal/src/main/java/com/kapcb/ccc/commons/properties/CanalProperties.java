package com.kapcb.ccc.commons.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <a>Title: CanalProperties </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 14:48
 */
@Slf4j
@Component(value = "canalProperties")
@ConfigurationProperties
public class CanalProperties {
}
