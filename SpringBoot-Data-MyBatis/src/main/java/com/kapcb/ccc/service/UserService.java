package com.kapcb.ccc.service;

import com.kapcb.ccc.pojo.UserPojo;
import com.kapcb.ccc.vo.UserVO;

import java.util.List;

/**
 * <a>Title: UserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/23 22:05
 */
public interface UserService {

    boolean insertUser(UserVO userVO);

    boolean logicDeleteUser(Long id);

    boolean logicBatchDeleteUser(List<Long> id);

    boolean deleteUser(Long id);

    boolean batchDelete(List<Long> id);

    boolean updateUser(UserVO userVO, Long id);

    UserPojo getUser(Long id);
}
