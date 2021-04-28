package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title:DeptController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 11:36
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DeptController {

    private final DeptService deptService;

    /**
     * 注解方式
     *
     * @param id Integer
     * @return Dept
     */
    @GetMapping(path = "dept/{id}")
    public Dept getById(@PathVariable Integer id) {
        Dept dept = this.deptService.getById(id);
        return dept;
    }

    /**
     * 编码的方式
     *
     * @param id Integer
     * @return Dept
     */
    @RequestMapping(path = "dept2/{id}")
    public Dept getByIdTest(@PathVariable Integer id) {
        Dept dept = this.deptService.getByIdTest(id);
        return dept;
    }
}
