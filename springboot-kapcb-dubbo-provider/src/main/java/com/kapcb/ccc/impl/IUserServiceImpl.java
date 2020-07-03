package com.kapcb.ccc.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kapcb.ccc.domain.UserInfo;
import com.kapcb.ccc.service.IUserInfoService;
import com.kapcb.ccc.utils.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title:IUserServiceImpl</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:24
 */
@Service
@Component
public class IUserServiceImpl implements IUserInfoService {

    public static final Integer USE_ONE = 1;
    public static final Integer USE_TWO = 2;

    @Override
    public List<UserInfo> getUserInfo(Integer userId) {

        if (USE_ONE.equals(userId)) {
            UserInfo kapcb = new UserInfo(1, "kapcb", "eircccallroot@163.com", "12346789", DateUtil.StringToDate("1997-03-11 10:10:10"));
            return Arrays.asList(kapcb);
        }
        if (USE_TWO.equals(userId)) {
            UserInfo ccc = new UserInfo(2, "ccc", "eircccallroot@yeah.net", "123456789", DateUtil.StringToDate("1996-03-11 20:20:20"));
            return Arrays.asList(ccc);
        } else {
            return null;
        }
    }
}
