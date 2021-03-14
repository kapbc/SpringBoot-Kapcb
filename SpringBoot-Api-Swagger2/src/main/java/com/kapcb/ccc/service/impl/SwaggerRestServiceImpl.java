package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.dao.SwaggerRestDAO;
import com.kapcb.ccc.domain.UserVO;
import com.kapcb.ccc.service.SwaggerRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: SwaggerRestServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 15:22
 */
@Slf4j
@Component(value = "swaggerRestService")
public class SwaggerRestServiceImpl implements SwaggerRestService {


    /**
     * @param id Long
     * @return UserVO
     */
    @Override
    public UserVO getTestUserByUserId(Long id) {
        List<UserVO> userVOList = SwaggerRestDAO.USER_VO_MAP.get(SwaggerRestDAO.DATA_SOURCE_NAME);
        UserVO userVO = userVOList.stream().filter(s -> Objects.equals(id, s.getId())).max(Comparator.comparing(UserVO::getBirthday)).orElseGet(UserVO::new);
        log.info("the user query by id is : " + userVO);
        return userVO;
    }
}
