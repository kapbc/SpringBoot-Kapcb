package com.kapcb.ccc.controller;

import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: User Task Controller <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/15 17:16
 */
@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserTaskController {

    private final IUserService userService;

    @GetMapping("user/{count}")
    public String batchSync(@PathVariable(value = "count") Integer count) {
        log.info("the batch sync count is : " + count);
        List<UserPO> batchAsyncData = getBatchAsyncData();
        int listSize = batchAsyncData.size();

        int threadSum = 2 * Runtime.getRuntime().availableProcessors();

        if (threadSum > listSize) {
            threadSum = listSize;
        }

        CountDownLatch countDownLatch = new CountDownLatch(listSize);
        for (int i = 0; i < threadSum; i++) {
            int listStart = (listSize / threadSum) * i;
            int listEnd = (listSize / threadSum) * (i + 1);

            if (i == threadSum - 1) {
                listEnd = listSize;
            }

            List<UserPO> subUserList = batchAsyncData.subList(listStart, listEnd);
            userService.executeSync(subUserList, countDownLatch);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("user batch execute sync error, error message is : " + e.getMessage());
            return "batch execute sync fail";
        }
        return "batch execute sync success";
    }

    private static List<UserPO> getBatchAsyncData() {
        List<UserPO> userList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            userList.add(UserPO.builder()
                    .userName("test : " + i)
                    .userId((long) (20000000 + i))
                    .email("test" + i + "email@kapcb.com")
                    .password("test" + i + "password")
                    .supplierId((long) (30000000 + i))
                    .productOwner("test product owner : " + i)
                    .build());
        }
        return userList;
    }


}
