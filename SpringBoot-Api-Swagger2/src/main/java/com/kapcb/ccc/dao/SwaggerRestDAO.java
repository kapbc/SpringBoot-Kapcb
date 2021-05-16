package com.kapcb.ccc.dao;

import com.kapcb.ccc.domain.UserVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a>Title: SwaggerRestDAO </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 15:23
 */
@Slf4j
public class SwaggerRestDAO {

    private static final int INITIAL_CAPACITY = 6;

    public static final String DATA_SOURCE_NAME = "dataSourceOne";

    public static final Map<String, List<UserVO>> USER_VO_MAP = new HashMap<>(INITIAL_CAPACITY);

    private SwaggerRestDAO() {
    }

    static {
        USER_VO_MAP.put(DATA_SOURCE_NAME, new ArrayList<UserVO>() {

            private static final long serialVersionUID = -8077655037686385384L;

            {
                add(new UserVO.Builder().id(18L).age(18).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(22L).age(19).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(13L).age(20).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(32L).age(21).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(13L).age(22).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(15L).age(23).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(16L).age(24).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(17L).age(25).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(18L).age(26).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(19L).age(27).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(10L).age(28).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(43L).age(29).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(64L).age(30).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
                add(new UserVO.Builder().id(74L).age(31).username("kapcb").email("eircccallroot@yhea.net").address("深圳市南山区深圳湾壹号").birthday(new Date()).build());
            }
        });
    }

}
