package com.kapcb.ccc.commons.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ThreadPoolUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/10 22:39
 */
@Slf4j
public class ThreadPoolUtil {

    private ThreadPoolUtil() {
    }

    /**
     * 手动创建线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE_POOL;

    static {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;
        Long keepAliveTime = 5L;
        TimeUnit keepAliveTimeUnit = TimeUnit.MINUTES;
        int queueSize = 100_000;
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("Email-ThreadPool")
                .build();
        EXECUTOR_SERVICE_POOL = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveTime,
                keepAliveTimeUnit,
                new ArrayBlockingQueue<>(queueSize),
                threadFactory);
    }

    public static ExecutorService getThreadPool() {
        log.info("begin to get thread by hand create");
        return EXECUTOR_SERVICE_POOL;
    }

}
