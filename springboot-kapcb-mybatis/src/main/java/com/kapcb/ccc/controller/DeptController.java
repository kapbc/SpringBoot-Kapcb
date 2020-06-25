package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.mapper.DeptMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
 * @date 2020/6/25 13:29
 */
@RestController
@RequiredArgsConstructor
public class DeptController {

    private final DeptMapper deptMapper;

    @RequestMapping(path = "dept/{id}")
    public List<Dept> demo1(@PathVariable Integer id) {
        List<Dept> byId = this.deptMapper.getById(id);
        return byId;
    }

    @RequestMapping(path = "dept")
    public Dept demo2(@NonNull Dept dept) {
        this.deptMapper.addDept(dept);
        return dept;
    }
}
