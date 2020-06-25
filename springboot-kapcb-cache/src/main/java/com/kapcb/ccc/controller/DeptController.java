package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <a>Title:DeptController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 15:42
 */
@RestController
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    @GetMapping(path = "dept/{id}")
    public Dept getDept(@PathVariable Integer id){
        Dept dept = this.deptService.getDept(id);
        return dept;
    }

    @GetMapping(path = "dept")
    public Dept update(Dept dept){
        Dept dept1 = this.deptService.updateDept(dept);
        return dept1;
    }
}
