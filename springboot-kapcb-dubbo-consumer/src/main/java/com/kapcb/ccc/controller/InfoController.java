package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.UserInfo;
import com.kapcb.ccc.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <a>Title:InfoController</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:16
 */
@Controller
public class InfoController {

    @Autowired(required = false)
    private IInfoService iInfoService;

    @ResponseBody
    @GetMapping(path = "list/{userId}")
    public List<UserInfo> list(@PathVariable("userId") Integer userId){
        List<UserInfo> list = this.iInfoService.list(userId);
        return list;
    }
}
