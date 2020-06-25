package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <a>Title:DeptService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/25 15:38
 */
@Service
@RequiredArgsConstructor
public class DeptService {

    private final DeptMapper deptMapper;

    /**
     * 将方法的运行结果进行缓存，再次调用相同的数据，
     * 直接从缓存中获取，不调用方法连接数据库
     * <p>
     * CacheManager管理多个Cache组件，对于缓存的真正CRUD操作在Cache组件中，每一个缓存组件都有自己唯一的名字
     * Cacheable的属性：
     * cacheNames：指定缓存组件的名字
     * key：缓存数据时使用的key，可以用它来进行指定。不指定的话默认使用方法参数的值作为key。如：传入值为1，不进行指定就默认为： 1-方法结果，可使用SpEL表达式编写
     * 编写SpEL表达式：#id 获取参数列表中的id， #a0 #p0 #root.args[0]
     * <p>
     * keyGenerator: key的生成器，可以自己指定key的生成器的组件id
     * <p>
     * keyGenerator和key：二选一
     * <p>
     * cacheManager：指定缓存管理器，或者使用cacheResolver指定获取缓存解析器，也是二选一
     * <p>
     * condition：指定符合条件的情况下才进行缓存
     * condition = "#id>0"：传入的参数id>0满足条件则进行缓存
     * unless：否定缓存，当unless指定的条件为true，方法的返回值就不会进行缓存，可以获取到结果进行判断
     * unless = "#result==null"：结果为空时进行缓存
     * sync：是否使用异步模式
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept")
    public Dept getDept(Integer id) {
        System.out.println("查询" + id + "部门");
        Dept deptList = this.deptMapper.getById(id);
        return deptList;
    }

    /**
     * 即调用方法，又更新缓存
     * <p>
     * 运行流程：
     * 1、先调用目标方法
     * 2、然后将目标方法的结果进行缓存
     * <p>
     * 测试步骤
     * 1、先查询 1 号
     * 2、再次查询 1 号还是同样的结果且控制台无输出，证明以及进行缓存
     * 3、更新 1 号部门的部门名称为 AA
     * 4、再来查询 1 号，结果为之前查询出的结果 aa
     * 说明：缓存中存放结果为 k-v的形式
     * @CachePut：调用方法之后将方法返回值放入缓存之中
     * 不同的是使用CachePut进行缓存时的 key：传入的dept对象 值：返回的dept对象
     *  也就是说之前缓存的部门信息没有进行修改之后的更新
     *  解决办法：进行key指定即可
     *  1、key = "#dept.id"：使用传入的参数的id
     *  2、key = "#result.id":因为返回的值时dept，所以 #result.id 等同于 #dept.id
     *  注意 @Cacheable是不能使用"#result.id"进行指定的，因为@Cacheable是在方法执行之前而，@CachePut是先执行方法
     * @param dept Dept
     * @return Dept
     */
    @CachePut(value = "dept",key = "#result.id")
    public Dept updateDept(Dept dept) {
        System.out.println("跟新部门的方法被调用了");
        this.deptMapper.updateDept(dept);
        return dept;
    }

}
