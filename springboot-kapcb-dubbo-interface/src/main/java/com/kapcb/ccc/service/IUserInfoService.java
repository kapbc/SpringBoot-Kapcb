package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.UserInfo;

import java.util.List;

/**
 * <a>Title:IUserInfoService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:22
 */
public interface IUserInfoService {

    /**
     * 获取用户信息
     *
     * @param userId Integer
     * @return List<UserInfo>
     */
    List<UserInfo> getUserInfo(Integer userId);
}
