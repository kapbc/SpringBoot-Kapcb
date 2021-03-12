package ${package_service_impl};

import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import lombok.extern.slf4j.Slf4j;
import ${package_service}.${Table}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
@Slf4j
@Service(value = "${table}Service")
public class ${Table}ServiceImpl implements ${Table}Service {

    @Autowired
    private ${Table}Mapper ${table}Mapper;

    /**
     * ${Table}条件+分页查询
     * @param ${table} 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<${Table}> findPage(${Table} ${table}, int page, int size){
        log.info("come into ${Table}ServiceImpl findPage method");
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(${table});
        //执行搜索
        return new PageInfo<>(${table}Mapper.selectByExample(example));
    }

    /**
     * ${Table}分页查询
     * @param page 页码
     * @param size 页大小
     * @return
     */
    @Override
    public PageInfo<${Table}> findPage(int page, int size){
        log.info("come into ${Table}ServiceImpl findPage method");
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(${table}Mapper.selectAll());
    }

    /**
     * ${Table}条件查询
     * @param ${table} ${table}
     * @return List<${Table}>
     */
    @Override
    public List<${Table}> findList(${Table} ${table}){
        log.info("come into ${Table}ServiceImpl findList method");
        //构建查询条件
        Example example = createExample(${table});
        //根据构建的条件查询数据
        return ${table}Mapper.selectByExample(example);
    }


    /**
     * ${Table}构建查询对象
     * @param ${table} ${table}
     * @return Example
     */
    public Example createExample(${Table} ${table}){
        log.info("come into ${Table}ServiceImpl createExample method");
        Example example=new Example(${Table}.class);
        Example.Criteria criteria = example.createCriteria();
        if(${table}!=null){
        log.info("begin to create dynamic query");
            <#list models as md>
            // ${md.desc}
            if(!StringUtils.isEmpty(${table}.get${md.upperName}())){
                <#if (md.name?contains("title") || md.name?contains("name"))>
                    criteria.andLike("${md.name}","%"+${table}.get${md.upperName}()+"%");
                <#else>
                    criteria.andEqualTo("${md.name}",${table}.get${md.upperName}());
                </#if>
            }
            </#list>
        }
        log.info("create dynamic query success");
        log.info("the create dynamic is : " + criteria.toString());
        return example;
    }

    /**
     * 删除
     * @param id id
     */
    @Override
    public void delete(${keyType} id){
        log.info("come into ${Table}ServiceImpl delete method");
        log.info("the delete id is : " + id);
        ${table}Mapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改${Table}
     * @param ${table} ${table}
     */
    @Override
    public void update(${Table} ${table}){
        log.info("come into ${Table}ServiceImpl update method");
        log.info("the update table info is : " + ${table});
        ${table}Mapper.updateByPrimaryKey(${table});
    }

    /**
     * 增加${Table}
     * @param ${table} ${table}
     */
    @Override
    public void add(${Table} ${table}){
        log.info("come into ${Table}ServiceImpl add method");
        log.info("the add table info is : " + ${table});
        ${table}Mapper.insert(${table});
    }

    /**
     * 根据ID查询${Table}
     * @param id id
     * @return ${Table}
     */
    @Override
    public ${Table} findById(${keyType} id){
        log.info("come into ${Table}ServiceImpl findById method");
        log.info("the findById id is : " + id);
        return  ${table}Mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询${Table}全部数据
     * @return List<${Table}>
     */
    @Override
    public List<${Table}> findAll() {
        log.info("come into ${Table}ServiceImpl findAll method");
        return ${table}Mapper.selectAll();
    }
}
