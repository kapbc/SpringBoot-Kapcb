package com.kapcb.ccc.service;

import com.github.pagehelper.PageInfo;
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

    /**
     * insert User {@link UserPojo}
     *
     * @param userVO {@link UserVO}
     * @return boolean
     */
    boolean insertUser(UserVO userVO);

    /**
     * insert User {@link UserPojo}
     *
     * @param userVO {@link UserVO}
     * @return boolean
     */
    boolean insertUserByAnnotation(UserVO userVO);

    /**
     * logic delete user {@link UserPojo}
     *
     * @param id Long
     * @return boolean
     */
    boolean logicDeleteUser(Long id);

    /**
     * logic batch delete
     *
     * @param id List<Long>
     * @return boolean
     */
    boolean logicBatchDeleteUser(List<Long> id);

    /**
     * delete user {@link UserPojo}
     *
     * @param id Long
     * @return boolean
     */
    boolean deleteUser(Long id);

    /**
     * batch delete
     *
     * @param id List<id>
     * @return boolean
     */
    boolean batchDelete(List<Long> id);

    /**
     * update user {@link UserPojo}
     *
     * @param userVO {@link UserVO}
     * @param id     Long
     * @return boolean
     */
    boolean updateUser(UserVO userVO, Long id);

    /**
     * get user {@link UserPojo}
     *
     * @param id Long
     * @return {@link UserPojo}
     */
    UserPojo getUser(Long id);

    /**
     * get user vo list
     *
     * @param page Integer
     * @param size Integer
     * @return List<UserVO>
     */
    PageInfo<UserPojo> getUserVOList(Integer page, Integer size);
}
