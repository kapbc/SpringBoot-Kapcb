package com.kapcb.ccc.commons.config;

import com.alibaba.otter.canal.client.CanalConnector;
import com.kapcb.ccc.commons.properties.CanalProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: CanalConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 9:35
 */
@Slf4j
@Configuration
public class CanalConfiguration {

    @Bean
    @ConditionalOnBean(name = "canalProperties")
    public CanalConnector canalConnector(CanalProperties canalProperties) {

    }

}
