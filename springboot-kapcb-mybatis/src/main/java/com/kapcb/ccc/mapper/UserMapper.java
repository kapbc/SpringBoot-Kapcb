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
 * @date 2020/6/19 14:32
 */
public interface UserMapper {

    /**
     * 分页显示所有用户信息
     *
     * @param map Map<String, Object>
     * @return List<User>
     */
    public List<User> findAllUser(Map<String, Object> map);

    /**
     * 根据id批量查询用户
     *
     * @param ids String[]
     * @return List<User>
     */
    public List<User> findUserByList(String[] ids);

    /**
     * 根据用户名，邮箱进行多条件模糊查询
     *
     * @param username username
     * @param email    email
     * @return List<User>
     */
    public List<User> findUserByQuery(@Param("username") String username, @Param("email") String email);

    /**
     * 模糊查询并分页
     *
     * @param map Map<String, Object>
     * @return List<User>
     */
    public List<User> findUserByQueryBatch(Map<String, Object> map);

    /**
     * 新增用户
     *
     * @param user User
     * @return boolean
     */
    public boolean addUser(User user);

    /**
     * 输出用户 批量/单个
     *
     * @param userIds String[]
     * @return boolean
     */
    public boolean deleteUser(String[] userIds);

    /**
     * 跟新用户
     *
     * @param user User
     * @return boolean
     */
    public boolean updateUser(User user);

}
