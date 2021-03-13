package com.kapcb.ccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan//druid监控页面是一个servlet，需要让SpingBoot支持servlet
public class SpringbootKapcbDruidApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKapcbDruidApplication.class, args);
    }
}
