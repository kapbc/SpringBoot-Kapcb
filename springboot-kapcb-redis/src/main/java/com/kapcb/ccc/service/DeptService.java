package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * <a>Title:DeptService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 11:32
 */
@Service
@CacheConfig(cacheNames = "dept")
@RequiredArgsConstructor
public class DeptService {

    private final DeptMapper deptMapper;

    private final CacheManager cacheManager;

    @Cacheable(key = "#id")
    public Dept getById(Integer id) {
        System.out.println("查询部门id为：" + id);
        Dept dept = this.deptMapper.getById(id);
        return dept;
    }

    public Dept getByIdTest(Integer id) {
        System.out.println("调用getByIdTest，id为：" + id);
        Dept dept = this.deptMapper.getById(id);
        Cache cache = cacheManager.getCache("dept2");
        cache.put("coding:1", dept);
        return dept;
    }
}
