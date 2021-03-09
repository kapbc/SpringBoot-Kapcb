package com.kapcb.ccc.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/9 22:39
 */
@Slf4j

@RestController
@RequestMapping(value = "system")
public class SystemController {

    @ApiOperation(value = "order", notes = "order测试findById", tags = {"OrderController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "查找Order的id", required = true, dataType = "Long")
    })
    @GetMapping(path = "findById/{id}", produces = "application/json;charset=UTF-8")
    public String findById(@PathVariable(value = "id") Long id) {
        log.info("come into order controller's find by id");
        return "success";
    }
}
