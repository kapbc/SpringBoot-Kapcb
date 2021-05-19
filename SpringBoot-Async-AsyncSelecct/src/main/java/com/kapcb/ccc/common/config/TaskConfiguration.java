package com.kapcb.ccc.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/18 22:11
 */
@slf4j
@Configuration
public class TaskConfiguration {
  
    @Value("${user.core.poolSize}")
    private int userCorePoolSize = 5;

    @Value("${user.max.poolSize}")
    private int userMaxPoolSize = 10;

    @Value("${user.queue.capacity}")
    private int userQueueCapacity = 99999;

    @Value("${user.keepAlive.seconds}")
    private int keywordKeepAliveSeconds = 30;

    @Value("${user.thread.name.prefix}")
    private String keywordThreadNamePrefix = "keyword-batch-sync";

    @Bean(name = "userTaskExecutor")
    public ThreadPoolTaskExecutor advertKeywordTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(keywordCorePoolSize);
        executor.setMaxPoolSize(keywordMaxPoolSize);
        executor.setQueueCapacity(keywordQueueCapacity);
        executor.setKeepAliveSeconds(keywordKeepAliveSeconds);
        executor.setThreadNamePrefix(keywordThreadNamePrefix);
        // reject policy
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // wait all task down
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
  
}
