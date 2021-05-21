package com.kapcb.ccc.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/18 22:11
 */
@Configuration
public class TaskConfiguration {
  
    @Value("${user.core.poolSize}")
    private int userCorePoolSize = 5;

    @Value("${user.max.poolSize}")
    private int userMaxPoolSize = 10;

    @Value("${user.queue.capacity}")
    private int userQueueCapacity = 99999;

    @Value("${user.keepAlive.seconds}")
    private int userKeepAliveSeconds = 30;

    @Value("${user.thread.name.prefix}")
    private String userThreadNamePrefix = "keyword-batch-sync";

    @Bean(name = "userTaskExecutor")
    public ThreadPoolTaskExecutor userTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(userCorePoolSize);
        executor.setMaxPoolSize(userMaxPoolSize);
        executor.setQueueCapacity(userQueueCapacity);
        executor.setKeepAliveSeconds(userKeepAliveSeconds);
        executor.setThreadNamePrefix(userThreadNamePrefix);
        // reject policy
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // wait all task down
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
  
}
