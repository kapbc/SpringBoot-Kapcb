package com.kapcb.ccc.mapper;

import com.kapcb.ccc.pojo.UserPojo;
import com.kapcb.ccc.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/23 22:00
 */
@Repository
public interface UserMapper {

    int insertUser(UserPojo userPojo);

    int logicDeleteUser(Long id);

    int logicBatchDeleteUser(List<Long> id);

    int deleteUser(Long id);

    int batchDelete(List<Long> id);

    int updateUser(UserPojo userPojo, Long id);

    UserPojo getUser(Long id);
}