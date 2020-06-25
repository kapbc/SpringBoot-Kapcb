package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Dept;

import java.util.List;

/**
 * <a>Title:DeptMapper</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 13:25
 */
public interface DeptMapper {

    /**
     * 根据id查找部门
     *
     * @param id Integer
     * @return List<Dept>
     */
    List<Dept> getById(Integer id);

    /**
     * 新增部门
     *
     * @param dept Dept
     */
    void addDept(Dept dept);

}
