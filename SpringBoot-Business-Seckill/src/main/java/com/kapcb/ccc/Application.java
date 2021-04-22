package com.itstyle.seckill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动类
 * 创建者 爪哇笔记
 * 创建时间	2018年5月12日
 * API接口测试：http://localhost:8080/seckill/swagger-ui.html
 * 跑之前 一定要看文库：https://gitee.com/52itstyle/spring-boot-seckill/wikis
 * 妹子图微服务版本：https://gitee.com/52itstyle/SPTools-Cloud
 * 分库分表案例：https://gitee.com/52itstyle/spring-boot-sharding-sphere
 */
@EnableAsync
@SpringBootApplication
public class Application {

	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	/**
	 * 1. 数据库乐观锁；2. 基于Redis的分布式锁；3. 基于ZooKeeper的分布式锁
	 * 4. redis 订阅监听；5.kafka消息队列
	 * 启动前 请配置application.properties中相关redis、zk以及kafka相关地址
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("项目启动");
	}

}
