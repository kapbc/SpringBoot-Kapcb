package com.kapcb.ccc;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbRedisApplicationTests {


    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object,Dept> myRedisTemplate;

    @Test
    public void test() {
        Dept deptList = this.deptMapper.getById(1);
    }
    /*
    *   stringRedisTemplate.opsForValue(); 操作String字符串
        stringRedisTemplate.opsForHash(); 操作Hash散列
        stringRedisTemplate.opsForSet(); 操作Set集合
        stringRedisTemplate.opsForList(); 操纵List列表
        stringRedisTemplate.opsForZSet(); 操作ZSet有序集合
    * */

    @Test
    public void testRedis() {
        // 给redis中保存 key为msg value为hello的
        //stringRedisTemplate.opsForValue().append("msg","Hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void testRedisList() {
        //stringRedisTemplate.opsForList().leftPush("list","1");
        //stringRedisTemplate.opsForList().leftPush("list","2");
        //stringRedisTemplate.opsForList().leftPush("list","3");
        String list = stringRedisTemplate.opsForList().leftPop("list");
        System.out.println(list);
    }

    @Test
    public void testObject() {
        Dept deptList = this.deptMapper.getById(1);
        // 保存对象默认使用 jdk 的序列化机制
        redisTemplate.opsForValue().set("dept", deptList);

        //将数据转换为json的方式
        //1.自己将对象转换为json对象
        //2.redisTemplate有默认的序列化规则
    }

    @Test
    public void testRedisObject(){
        Dept deptList = this.deptMapper.getById(1);
        this.myRedisTemplate.opsForValue().set("dept02",deptList);
    }
}
