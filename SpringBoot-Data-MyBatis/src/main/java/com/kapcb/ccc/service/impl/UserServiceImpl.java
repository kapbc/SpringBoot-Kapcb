package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.pojo.UserPojo;
import com.kapcb.ccc.service.UserService;
import com.kapcb.ccc.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <a>Title: UserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/23 22:05
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(@Qualifier("userMapper") UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser(UserVO userVO) {
        UserPojo userPojo = new UserPojo();
        BeanUtils.copyProperties(userVO, userPojo);
        int impactColumns = this.userMapper.insertUser(userPojo);
        log.info("insert user impact columns is : " + impactColumns);
        return impactColumns > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean logicDeleteUser(Long id) {
        int impactColumns = this.userMapper.logicDeleteUser(id);
        log.info("logic delete user impact columns is : " + impactColumns);
        return impactColumns > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean logicBatchDeleteUser(List<Long> id) {
        int impactColumns = this.userMapper.logicBatchDeleteUser(id);
        log.info("logic delete user impact columns is : " + impactColumns);
        return impactColumns > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(Long id) {
        int impactColumns = this.userMapper.deleteUser(id);
        log.info("delete user impact columns is : " + impactColumns);
        return impactColumns > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchDelete(List<Long> idList) {
        int impactColumns = this.userMapper.batchDelete(idList);
        log.info("delete user impact columns is : " + impactColumns);
        return impactColumns > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(UserVO userVO, Long id) {
        UserPojo userPojo = new UserPojo();
        BeanUtils.copyProperties(userVO, userPojo);
        log.info("the update user is : " + userPojo + " the id is : " + id);
        int impactColumns = this.userMapper.updateUser(userPojo, id);
        log.info("update user impact columns is : " + impactColumns);
        return impactColumns > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public UserPojo getUser(Long id) {
        UserPojo user = this.userMapper.getUser(id);
        log.info("the user is : " + user);
        return Optional.ofNullable(user).orElseGet(UserPojo::new);
    }
}
