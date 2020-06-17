package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <a>Title:UserMapper</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/16 9:02
 */
public interface UserMapper {

    /**
     * 显示所有用户
     *
     * @param map Map<String,Object>
     * @return List<User>
     */
    public List<User> findAllUser(Map<String, Object> map);

    /**
     * 多条件模糊查询
     *
     * @param username username
     * @param email    email
     * @return List<User>
     */
    public List<User> findUserByQuery(@Param("username") String username, @Param(value = "email") String email);

    /**
     * 多条件模糊查询升级版
     *
     * @param map Map<String,Object>
     * @return List<User>
     */
    public List<User> findUserByBatch(Map<String, Object> map);

    /**
     * 新增用户
     *
     * @param user User
     * @return boolean
     */
    public boolean insertUser(User user);


    /**
     * 删除用户
     *
     * @param ids String[]
     * @return boolean
     */
    public boolean deleteUser(String[] ids);

    /**
     * 修改用户
     *
     * @param user User
     * @return boolean
     */
    public boolean updateUser(User user);
}
