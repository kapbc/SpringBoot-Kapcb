package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <a>Title:DeptController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/24 23:33
 */
@RestController
@RequiredArgsConstructor
public class DeptController {


    private final DeptMapper deptMapper;

    @RequestMapping(path = "dept/{id}")
    public List<Dept> deptById(@PathVariable Integer id) {
        List<Dept> deptById = this.deptMapper.getDeptById(id);
        return deptById;
    }

    @RequestMapping(path = "dept")
    public Dept deptInsert(Dept dept) {
        this.deptMapper.addDept(dept);
        //返回添加的信息
        return dept;
    }
}
