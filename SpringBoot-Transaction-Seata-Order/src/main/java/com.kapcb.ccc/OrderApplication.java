package com.kapcb.ccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <a>Title: OrderApplication </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/9/16 22:39
 */
@MapperScan(basePackages = {"com.kapcb.ccc.mapper"})
@EnableFeignClients(basePackages = {"com.kapcb.ccc.feign"})
@SpringCloudApplication
public class OrderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(OrderApplication.class)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
