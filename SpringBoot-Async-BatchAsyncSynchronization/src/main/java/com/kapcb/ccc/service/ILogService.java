package com.kapcb.ccc.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/11 22:43
 */
public interface ILogService {

    void executeAsync(List<String> keywordList, CountDownLatch countDownLatch);
}
