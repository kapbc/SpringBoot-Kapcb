package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootMybatisApplicationTests {

    private static final int INITIAL_CAPACITY = 2;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testFindAllUser() {
        Map<String, Object> map = new HashMap<>(INITIAL_CAPACITY);
        map.put("currentIndex", 0);
        map.put("pageSize", 5);
        List<User> allUser = userMapper.findAllUser(map);
        allUser.stream().map(User::getUsername).collect(Collectors.toSet()).forEach(System.out::println);
    }

    @Test
    public void testFindUserByQuery() {
        String username = "kapcb";
        String email = "eircccallroot@163.com";
        List<User> userByQuery = this.userMapper.findUserByQuery(username, email);
        userByQuery.stream().collect(Collectors.toList()).forEach(System.out::println);
    }


    @Test
    public void testFindUserByBatch() {
        Map<String, Object> map = new HashMap<>(INITIAL_CAPACITY);
        map.put("username", "kapcb");
        List<User> userByBatch = this.userMapper.findUserByBatch(map);
        userByBatch.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123456");
        user.setPhone("123456");
        user.setCreated(new Date());
        user.setUpdated(new Date());
        boolean b = this.userMapper.insertUser(user);
        if (b) {
            System.out.println("新增用户成功！");
        } else {
            System.out.println("新增用户失败！");
        }
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(39);
        user.setUsername("testUpdateUser");
        boolean b = this.userMapper.updateUser(user);
        if (b) {
            System.out.println("修改用户信息成功！");
        } else {
            System.out.println("修改用户信息失败");
        }
    }

    @Test
    public void testDeleteUser() {
        String userIds = "11,12";
        String[] ids = userIds.split(",");
        boolean b = this.userMapper.deleteUser(ids);
        if (b) {
            System.out.println("删除用户信息成功！");
        } else {
            System.out.println("删除用户信息失败");
        }
    }
}
