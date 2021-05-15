package com.kapcb.ccc.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: User Task Configuration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/15 17:56
 */
@Configuration
public class UserTaskConfiguration {

    @Value("${user.task.core.poolSize}")
    private int corePoolSize;

    @Value("${user.task.max.poolSize}")
    private int maxPoolSize;

    @Value("${user.task.queue.capacity}")
    private int queueCapacity;

    @Value("${keep.alive.seconds}")
    private int keepAliveSeconds;

    @Value("${user.task.thread.name.prefix}")
    private String threadNamePrefix;


    @Bean("userTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}
