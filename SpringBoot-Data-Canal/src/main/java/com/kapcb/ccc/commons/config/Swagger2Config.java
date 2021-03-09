package com.kapcb.ccc.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <a>Title: Swagger2Config </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/4-10:02
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket getOrderDocket(){
        ApiInfo apiInfo=new ApiInfoBuilder()
                //api标题
                .title("订单管理")
                //api描述
                .description("用户管理相关接口描述")
                //版本号
                .version("1.0.0")
                .build();
        //文档类型（swagger2）
        return new Docket(DocumentationType.SWAGGER_2)
                //设置包含在json ResourceListing响应中的api元信息
                .apiInfo(apiInfo)
                //启动用于api选择的构建器
                .select()
                //扫描接口的包
                .apis(RequestHandlerSelectors.basePackage("com.kapcb.ccc.controller"))
                //路径过滤器（扫描所有路径）
                .paths(PathSelectors.any())
                .build();
    }
}
