package com.kapcb.ccc.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.model.po.SubjectPO;
import com.kapcb.ccc.model.po.UserPO;
import com.kapcb.ccc.service.SubjectService;
import com.kapcb.ccc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <a>Title: UserServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/9 13:20
 */
@Slf4j
@Service
@DS("slave")
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

    private final SubjectService subjectService;

    @Override
    public UserPO getUserInfo(Long userId) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<UserPO>()
                .eq(UserPO::getId, userId)
                .last("LIMIT 1"));
    }

    @Override
    public UserPO getUserAndSubjectInfo(Long userId) {
        UserPO userInfo = this.getUserInfo(userId);
        if (Objects.nonNull(userInfo) && Objects.nonNull(userInfo.getSubjectId())) {
            SubjectPO subjectInfo = subjectService.getSubjectInfo(userInfo.getSubjectId());
            log.info("the subject info is : " + subjectInfo);
        }
        return null;
    }
}
