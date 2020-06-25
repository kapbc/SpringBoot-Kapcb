package com.kapcb.ccc;

import com.kapcb.ccc.domain.Dept;
import com.kapcb.ccc.mapper.DeptMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbCacheApplicationTests {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Test
    public void test(){
        Dept byId = this.deptMapper.getById(2);
        System.out.println(byId);
    }

}
