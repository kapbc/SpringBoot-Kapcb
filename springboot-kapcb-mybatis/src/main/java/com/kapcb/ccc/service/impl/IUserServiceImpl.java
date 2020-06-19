package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <a>Title:IUserServiceImpl</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/19 14:40
 */
@Service("1.0.0")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class IUserServiceImpl implements IUserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser(Map<String, Object> map) {
        return this.userMapper.findAllUser(map);
    }

    @Override
    public List<User> findUserByList(String[] ids) {
        return this.userMapper.findUserByList(ids);
    }

    @Override
    public List<User> findUserByQuery(String username, String email) {
        return this.userMapper.findUserByQuery(username, email);
    }

    @Override
    public List<User> findUserByQueryBatch(Map<String, Object> map) {
        return this.userMapper.findUserByQueryBatch(map);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user) {
        user.setUpdated(new Date());
        user.setCreated(new Date());
        this.userMapper.addUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(String[] userIds) {
        this.userMapper.deleteUser(userIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(User user) {
        this.userMapper.updateUser(user);
    }
}
