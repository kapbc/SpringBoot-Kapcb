package ${package_service};

import ${package_pojo}.${Table};
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
public interface ${Table}Service {

    /***
     * ${Table}多条件分页查询
     * @param ${table} 查询条件
     * @param page 页码
     * @param size
     * @return PageInfo<${Table}>
     */
    PageInfo<${Table}> findPage(${Table} ${table}, int page, int size);

    /***
     * ${Table}分页查询
     * @param page 页码
     * @param size 页大小
     * @return PageInfo<${Table}>
     */
    PageInfo<${Table}> findPage(int page, int size);

    /***
     * ${Table}多条件搜索方法
     * @param ${table} ${table}
     * @return List<${Table}>
     */
    List<${Table}> findList(${Table} ${table});

    /***
     * 删除${Table}
     * @param id id
     */
    void delete(${keyType} id);

    /***
     * 修改${Table}数据
     * @param ${table} ${table}
     */
    void update(${Table} ${table});

    /***
     * 新增${Table}
     * @param ${table} ${table}
     */
    void add(${Table} ${table});

    /**
     * 根据ID查询${Table}
     * @param id id
     * @return ${Table}
     */
     ${Table} findById(${keyType} id);

    /***
     * 查询所有${Table}
     * @return List<${Table}>
     */
    List<${Table}> findAll();
}
