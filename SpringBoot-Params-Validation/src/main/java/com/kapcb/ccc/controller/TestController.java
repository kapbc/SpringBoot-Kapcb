package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.entity.ResultInfo;
import com.kapcb.ccc.commons.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <a>Title: TestController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/15 22:00
 */
@Slf4j
@Validated
@RestController
@RequestMapping(value = "test")
public class TestController {

    @PostMapping(value = "beanValidation")
    public ResultInfo.Builder testBeanValidation(@RequestBody @Valid UserVO userVO) {
        log.info("the userVO is : " + userVO);
        return new ResultInfo.Builder().message("process success").code(HttpStatus.OK.value()).data("");
    }
}
