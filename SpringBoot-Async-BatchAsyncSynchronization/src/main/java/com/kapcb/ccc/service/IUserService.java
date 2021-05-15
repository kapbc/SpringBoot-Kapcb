package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.UserPO;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/15 17:28
 */
public interface IUserService extends IService<UserPO> {

    void executeSync(List<UserPO> subUserList, CountDownLatch countDownLatch);

}
