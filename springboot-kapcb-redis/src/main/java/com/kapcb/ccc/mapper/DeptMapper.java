package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Dept;

import java.util.List;

/**
 * <a>Title:DeptMAPPER</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 23:27
 */
public interface DeptMapper {

    /**
     * 查询
     *
     * @param id Integer
     * @return Dept
     */
    Dept getById(Integer id);

    /**
     * 修改
     *
     * @param dept Dept
     * @return boolean
     */
    boolean updateDept(Dept dept);

    /**
     * 删除
     *
     * @param id Integer
     * @return boolean
     */
    boolean deleteDept(Integer id);

    /**
     * 新增
     *
     * @param dept Dept
     * @return boolean
     */
    boolean addDept(Dept dept);


}
