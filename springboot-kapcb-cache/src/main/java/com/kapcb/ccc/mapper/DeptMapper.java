package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <a>Title:DeptMapper</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 15:15
 */
public interface DeptMapper {

    /**
     * 根据id查询用户
     *
     * @param id Integer
     * @return List<Dept>
     */
    @Select("select * from tb_dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 修改用户
     *
     * @param dept Dept
     */
    @Update("update tb_dept set dept_name = #{deptName}")
    void updateDept(Dept dept);

    /**
     * 新增用户
     *
     * @param dept Dept
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tb_dept (dept_name) values (#{deptName})")
    void insertDept(Dept dept);

    /**
     * 删除用户
     *
     * @param id Integer
     */
    @Delete("delete from tb_dept where id = #{id}")
    void deleteDept(Integer id);

    /**
     * 根据名称查询
     *
     * @param name String
     * @return Dept
     */
    @Select("select * from tb_dept where dept_name = #{name}")
    Dept getDeptByName(String name);
}
