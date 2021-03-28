package com.kapcb.ccc.mapper;

import com.kapcb.ccc.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;
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

    /**
     * insert User {@link UserPojo}
     *
     * @param userPojo {@link UserPojo}
     * @return int
     */
    int insertUser(UserPojo userPojo);

    /**
     * insert User {@link UserPojo}
     *
     * @param userPojo {@link UserPojo}
     * @return int
     */
    int insertUserByAnnotation(@Param("bean") UserPojo userPojo);

    /**
     * logic delete user {@link UserPojo}
     *
     * @param id Long
     * @return int
     */
    int logicDeleteUser(@Param("id") Long id);

    /**
     * logic batch delete
     *
     * @param idList List<Long>
     * @return int
     */
    int logicBatchDeleteUser(@Param("idList") List<String> idList);

    /**
     * delete user {@link UserPojo}
     *
     * @param id Long
     * @return int
     */
    int deleteUser(@Param("id") Long id);

    /**
     * batch delete
     *
     * @param idList List<id>
     * @return int
     */
    int batchDelete(@Param("idList") List<String> idList);

    /**
     * update user {@link UserPojo}
     *
     * @param userPojo {@link UserPojo}
     * @param id       Long
     * @return int
     */
    int updateUser(@Param("bean") UserPojo userPojo, @Param("id") Long id);

    /**
     * get user {@link UserPojo}
     *
     * @param id Long
     * @return {@link UserPojo}
     */
    UserPojo getUser(@Param("id") Long id);

    /**
     * get user pojo
     *
     * @return List<UserPojo>
     */
    List<UserPojo> getUserPojoList();
}