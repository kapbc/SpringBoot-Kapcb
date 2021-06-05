package com.kapcb.ccc.common.core;

import com.kapcb.ccc.common.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Title: AsyncManager
 * @Author: Johann
 * @Description: AsyncManager
 * @date 2021/05/17 - 15:38
 */
@Slf4j
public class AsyncManager {

    private ScheduledExecutorService executor = SpringUtils.getBean("scheduledExecutorService");

    private static AsyncManager asyncManager = null;

    public synchronized static AsyncManager getInstance() {
        if (asyncManager == null) {
            asyncManager = new AsyncManager();
            return asyncManager;
        } else {
            return asyncManager;
        }
    }

    public void execute(TimerTask timerTask) {
        executor.schedule(timerTask, 10, TimeUnit.MICROSECONDS);
    }

    public void shutdown() {
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(120, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                    if (!executor.awaitTermination(120, TimeUnit.SECONDS)) {
                        log.info("Pool did not terminate");
                    }
                }
            } catch (InterruptedException ie) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

}
