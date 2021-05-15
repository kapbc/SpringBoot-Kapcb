package com.kapcb.ccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IUser Service Impl <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/15 17:27
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void executeSync(List<UserPO> subUserList, CountDownLatch countDownLatch) {
        Long userId = null;
        try {
            for (UserPO userPO : subUserList) {
                userId = userPO.getUserId();
                this.baseMapper.insert(userPO);
            }
        } catch (Exception e) {
            log.error("batch sync user error, the user id is : " + userId);
        }
    }
}