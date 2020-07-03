package com.kapcb.ccc.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kapcb.ccc.domain.UserInfo;
import com.kapcb.ccc.service.IInfoService;
import com.kapcb.ccc.service.IUserInfoService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title:IInfoServiceImpl</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:38
 */
@Service
public class IInfoServiceImpl implements IInfoService {

    @Reference
    private IUserInfoService iUserInfoService;

    @Override
    public List<UserInfo> list(Integer userId) {
        List<UserInfo> userInfo = this.iUserInfoService.getUserInfo(userId);
        return userInfo;
    }
}
