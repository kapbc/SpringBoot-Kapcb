package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.UserPO;

/**
 * <a>Title: UserService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/9 13:21
 */
public interface UserService extends IService<UserPO> {

    UserPO getUserInfo(Long userId);

    UserPO getUserAndSubjectInfo(Long userId);
}
