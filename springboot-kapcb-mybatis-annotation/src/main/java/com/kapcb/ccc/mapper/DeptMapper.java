package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <a>Title:DeptMapper</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/24 23:31
 */
@Mapper
public interface DeptMapper {

    /**
     * 根据id查询部门信息
     *
     * @param id Integer
     * @return List<Dept>
     */
    @Select("select * from tb_dept where id = #{id}")
    List<Dept> getDeptById(Integer id);

    /**
     * 新增部门
     *
     * @param dept Dept
     * @Options(useGeneratedKeys = true, keyProperty = "id")：获取自增主键
     * 将自增后的主键id返回给keyProperty中指定的属性
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tb_dept (dept_name) values (#{deptName})")
    void addDept(Dept dept);
}
