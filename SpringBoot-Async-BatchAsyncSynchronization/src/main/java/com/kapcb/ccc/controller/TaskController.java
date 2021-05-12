package com.kapcb.ccc.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.kapcb.ccc.common.configuration.call.TaskCallable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Task Controller <a>
 * https://blog.csdn.net/qq_18671415/article/details/110875246?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522162082966416780366532406%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=162082966416780366532406&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-20-110875246.pc_search_result_no_baidu_js&utm_term=SpringBoot%E5%A4%9A%E7%BA%BF%E7%A8%8B%E5%90%8C%E6%AD%A5%E6%95%B0%E6%8D%AE
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/12 22:33
 */
@RestController
@RequestMapping(value = "task")
public class TaskController {

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public String test1() {
        try {
            //10万条数据
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            for (int i = 1; i <= 100000; i++) {
                list.add("test:" + i);
            }

            //每条线程处理的数据尺寸
            int size = 250;
            int count = list.size() / size;
            if (count * size != list.size()) {
                count++;
            }
            int countNum = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(count);
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
            while (countNum < list.size()) {
                countNum += size;
                TaskCallable callable = new TaskCallable();
                //截取list的数据，分给不同线程处理
                callable.setList(ImmutableList.copyOf(list.subList(countNum - size, countNum < list.size() ? countNum : list.size())));
                ListenableFuture listenableFuture = listeningExecutorService.submit(callable);
                Futures.addCallback(listenableFuture, new FutureCallback<List<String>>() {
                    @Override
                    public void onSuccess(List<String> list1) {
                        countDownLatch.countDown();
                        list2.addAll(list1);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        countDownLatch.countDown();
//                        logger.info("处理出错：",throwable);

                    }
                });
            }
            countDownLatch.await(30, TimeUnit.MINUTES);
//            logger.info("符合条件的返回数据个数为："+list2.size());
//            logger.info("回调函数："+list2.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "正在处理......";
    }
}
