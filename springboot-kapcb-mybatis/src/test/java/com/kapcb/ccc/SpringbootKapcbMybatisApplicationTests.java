package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbMybatisApplicationTests {

    private static final int INITIAL_CAPACITY = 2;

    @Autowired
    private IUserService userService;

    /**
     * 测试分页显示
     */
    @Test
    public void testFindAllUser() {
        HashMap<String, Object> map = new HashMap<>(INITIAL_CAPACITY);
        map.put("currentPage", 0);
        map.put("pageSize", 4);
        List<User> allUser = this.userService.findAllUser(map);
        allUser.stream().forEach(System.out::println);
    }

    /**
     * 测试指定id查找
     */
    @Test
    public void testFindUserByList() {
        String userIds = "14,17,18";
        String[] ids = userIds.split(",");
        List<User> userByList = this.userService.findUserByList(ids);
        userByList.stream().map(User::getId).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 测试多条件模糊查询
     */
    @Test
    public void testFindUserByQuery() {
        String username = "kap";
        String email = "eircccallroot@163.com";
        List<User> userByQuery = this.userService.findUserByQuery(username, email);
        userByQuery.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testFindUserByQueryBatch() {
        HashMap<String, Object> map = new HashMap<>(INITIAL_CAPACITY);
        map.put("username", "kap");
        map.put("email", ".com");
        List<User> userByQueryBatch = this.userService.findUserByQueryBatch(map);
        userByQueryBatch.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 测试新增
     */
    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setPhone("1234567");
        user.setEmail("1234567@qq.com");
        this.userService.addUser(user);
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(40);
        user.setUsername("testUpdate");
        user.setEmail("testUpdate@qq.com");
        user.setUpdated(new Date());
        this.userService.updateUser(user);
    }

    /**
     * 测试删除
     */
    @Test
    public void test() {
        String userIds = "14,16";
        String[] ids = userIds.split(",");
        this.userService.deleteUser(ids);
    }
}
