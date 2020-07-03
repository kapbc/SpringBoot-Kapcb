package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.UserInfo;

import java.util.List;

/**
 * <a>Title:IInfoService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:18
 */
public interface IInfoService {

    /**
     * 获取用户列表
     *
     * @param userId Integer
     * @return List<UserInfo>
     */
    List<UserInfo> list(Integer userId);
}
