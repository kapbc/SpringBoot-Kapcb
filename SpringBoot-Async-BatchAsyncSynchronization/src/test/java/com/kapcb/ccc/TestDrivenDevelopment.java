package com.kapcb.ccc;

import com.kapcb.ccc.service.ILogService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Test Driven Development <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/11 22:49
 */
@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = {AsyncSynchronizationApplication.class})
public class TestDrivenDevelopment {

    @Autowired
    private ILogService iLogService;

    @Test
    public void testAsync() {
        List<String> data = getData();
        int size = data.size();
        int count = 1000;
        int totalPage = size / count;
        
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 1; i <= totalPage; i++) {
            int startNum = (i - 1) * count;
            int endNum = i * count;
            List<String> keywordSubList = data.subList(startNum, endNum);
            iLogService.executeAsync(keywordSubList,countDownLatch);
        }
        try {
            //保证之前的所有的线程都执行完成，才会走下面的
            // 这样就可以在下面拿到所有线程执行完的集合结果
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------");
    }

    private List<String> getData() {
        List<String> keywordList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            keywordList.add(UUID.randomUUID().toString());
        }
        return keywordList;
    }
}
