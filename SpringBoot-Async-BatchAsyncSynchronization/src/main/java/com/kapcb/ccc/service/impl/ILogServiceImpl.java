package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IKeywordService;
import com.kapcb.ccc.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/11 22:42
 */
@Service
public class ILogServiceImpl implements ILogService {

    @Autowired
    private IKeywordService iKeywordService;

    @Override
    @Async("threadPoolTaskExecutor")
    public void executeAsync(List<String> keywordList, CountDownLatch countDownLatch) {
        try {
            System.out.println("Current Thread Id is :  " + Thread.currentThread().getId());
            // 异步线程要做的事情
            keywordList.parallelStream().forEachOrdered(keyword -> iKeywordService.insertKeyword(keyword));
        } finally {
            // 很关键, 无论上面程序是否异常必须执行countDown,否则await无法释放
            countDownLatch.countDown();
        }
    }
}
