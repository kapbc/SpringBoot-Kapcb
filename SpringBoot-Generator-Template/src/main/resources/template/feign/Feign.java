package com.changgou.content.feign;

import ${package_pojo}.${Table};
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
@RequestMapping("/${table}")
@FeignClient(name="${serviceName}")
public interface ${Table}Feign {

    /***
     * ${Table}分页条件搜索实现
     * @param ${table}
     * @param page:当前页
     * @param size:每页显示多少条
     * @return Result<PageInfo>
     */
    //@PostMapping(value = "/search/{page}/{size}" )
    //Result<PageInfo> findPage(@RequestBody(required = false) ${Table} ${table}, @PathVariable  int page, @PathVariable  int size);

    /***
     * ${Table}分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return Result<PageInfo>
     */
    //@GetMapping(value = "/search/{page}/{size}" )
    //Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param ${table} ${table}
     * @return Result<List<${Table}>>
     */
    @PostMapping(value = "/search" )
    Result<List<${Table}>> findList(@RequestBody(required = false) ${Table} ${table});

    /***
     * 根据ID删除品牌数据
     * @param id id
     * @return Result
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable ${keyType} id);

    /***
     * 修改${Table}数据
     * @param ${table} ${table}
     * @param id id
     * @return Result
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ${Table} ${table},@PathVariable ${keyType} id);

    /***
     * 新增${Table}数据
     * @param ${table} ${table}
     * @return Result
     */
    @PostMapping
    Result add(@RequestBody ${Table} ${table});

    /***
     * 根据ID查询${Table}数据
     * @param id id
     * @return Result<${Table}>
     */
    @GetMapping("/{id}")
    Result<${Table}> findById(@PathVariable ${keyType} id);

    /***
     * 查询${Table}全部数据
     * @return Result<List<${Table}>>
     */
    @GetMapping
    Result<List<${Table}>> findAll();
}
