package ${package_controller};

import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import ${package_service}.impl.${Table}ServiceImpl;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
<#if swagger==true>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
</#if>
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
@Slf4j
@CrossOrigin
@RefreshScope
@RestController
@RequestMapping("/${table}")
<#if swagger==true>
@Api(tags = {"${Table}Controller"})
</#if>
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件搜索实现
     * @param ${table}
     * @param page:当前页
     * @param size:每页显示多少条
     * @return Result<PageInfo>
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件分页查询",notes = "分页条件查询${Table}方法详情",tags = {"${Table}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "int")
    })
    </#if>
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table}, @PathVariable  int page, @PathVariable  int size){
        log.info("come into ${Table}Controller's findPage method");
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(${table}, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ${Table}分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return Result<PageInfo>
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}分页查询",notes = "分页查询${Table}方法详情",tags = {"${Table}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "int")
    })
    </#if>
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        log.info("come into ${Table}Controller's findPage method");
        PageInfo<${Table}> pageInfo = ${table}Service.findPage(page, size);
        return new Result<>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param ${table} ${table}
     * @return Result<List<${Table}>>
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}条件查询",notes = "条件查询${Table}方法详情",tags = {"${Table}Controller"})
    </#if>
    @PostMapping(value = "/search" )
    public Result<List<${Table}>> findList(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table}){
        log.info("come into ${Table}Controller's findList method");
        List<${Table}> list = ${table}Service.findList(${table});
        return new Result<>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id id
     * @return Result
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID删除",notes = "根据ID删除${Table}方法详情",tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable ${keyType} id){
        log.info("come into ${Table}Controller's delete method");
        ${table}Service.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改${Table}数据
     * @param ${table} ${table}
     * @param id id
     * @return Result
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID修改",notes = "根据ID修改${Table}方法详情",tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @PutMapping(value="/{id}")
    public Result update(@RequestBody <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = false)</#if> ${Table} ${table},@PathVariable ${keyType} id){
        log.info("come into ${Table}Controller's update method");
        //设置主键值
        ${table}.${keySetMethod}(id);
        //调用${Table}Service实现修改${Table}
        ${table}Service.update(${table});
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增${Table}数据
     * @param ${table} ${table}
     * @return Result
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}添加",notes = "添加${Table}方法详情",tags = {"${Table}Controller"})
    </#if>
    @PostMapping
    public Result add(@RequestBody  <#if swagger==true>@ApiParam(name = "${Table}对象",value = "传入JSON数据",required = true)</#if> ${Table} ${table}){
        log.info("come into ${Table}Controller's add method");
        ${table}Service.add(${table});
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询${Table}数据
     * @param id id
     * @return Result<${Table}>
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID查询",notes = "根据ID查询${Table}方法详情",tags = {"${Table}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public Result<${Table}> findById(@PathVariable ${keyType} id){
        log.info("come into ${Table}Controller's findById method");
        ${Table} ${table} = ${table}Service.findById(id);
        return new Result<>(true,StatusCode.OK,"查询成功",${table});
    }

    /***
     * 查询${Table}全部数据
     * @return Result<List<${Table}>>
     */
    <#if swagger==true>
    @ApiOperation(value = "查询所有${Table}",notes = "查询所${Table}有方法详情",tags = {"${Table}Controller"})
    </#if>
    @GetMapping
    public Result<List<${Table}>> findAll(){
        log.info("come into ${Table}Controller's findAll method");
        List<${Table}> list = ${table}Service.findAll();
        return new Result<>(true, StatusCode.OK,"查询成功",list) ;
    }
}
