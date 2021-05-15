package com.kapcb.ccc.common.configuration;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: MyBatis Plus Configuration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/15 17:22
 */
@Slf4j
@Configuration
public class MyBatisPlusConfiguration {

    /**
     * MyBatis Plus Pagination Plus Configuration
     *
     * @return PaginationInnerInterceptor
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }
}
