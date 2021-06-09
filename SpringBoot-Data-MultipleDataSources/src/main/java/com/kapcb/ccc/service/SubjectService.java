package com.kapcb.ccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kapcb.ccc.model.po.SubjectPO;

/**
 * <a>Title: SubjectService </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/6/9 13:21
 */
public interface SubjectService extends IService<SubjectPO> {

    SubjectPO getSubjectInfo(Long subjectId);
}
