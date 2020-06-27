package com.kapcb.ccc.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <a>Title:AsyncService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 22:45
 */
@Service
public class AsyncService {

    /**
     * @Async：告诉Spring这是一个异步任务
     * 同时还要在主方法类上开启异步注解功能
     */
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中.....");
    }
}
