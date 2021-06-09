package com.kapcb.ccc.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kapcb.ccc.mapper.SubjectMapper;
import com.kapcb.ccc.model.po.SubjectPO;
import com.kapcb.ccc.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <a>Title: SubjectServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/9 13:21
 */
@Slf4j
@Service
@DS("master")
@RequiredArgsConstructor
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, SubjectPO> implements SubjectService {

    private static final String LAST_LIMIT_SQL = "LIMIT 1";

    @Override
    public SubjectPO getSubjectInfo(Long subjectId) {
        return this.baseMapper.selectOne(new LambdaQueryWrapper<SubjectPO>()
                .eq(SubjectPO::getId, subjectId)
                .last(LAST_LIMIT_SQL));
    }
}
