package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.UserVO;

/**
 * <a>Title: SwaggerRestService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 15:23
 */
public interface SwaggerRestService {

    /**
     * get userVO by user id
     *
     * @param id Long
     * @return UserVO {@link UserVO}
     */
    UserVO getTestUserByUserId(Long id);
}
