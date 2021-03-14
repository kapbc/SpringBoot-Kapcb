package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.entity.ResultInfo;
import com.kapcb.ccc.domain.UserVO;
import com.kapcb.ccc.service.SwaggerRestService;
import com.kapcb.ccc.service.impl.SwaggerRestServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <a>Title: SwaggerRestApiController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 15:14
 */
@Slf4j
@RestController
@RequestMapping(path = "swagger")
@Api(tags = {"SwaggerRestApiController"})
public class SwaggerRestApiController {

    private final SwaggerRestService swaggerRestService;

    @Autowired
    public SwaggerRestApiController(@Qualifier("swaggerRestService") SwaggerRestServiceImpl swaggerRestService) {
        this.swaggerRestService = swaggerRestService;
    }

    @PostMapping("test/{id}")
    @ApiOperation(value = "swagger", notes = "测试Swagger2的Rest风格的Api", tags = {"SwaggerRestApiController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "测试的Id", required = true, dataType = "Long")
    public Map<String, Object> testSwagger(@PathVariable(value = "id") Long id) {
        log.info("the test id is : " + id);
        UserVO userVO = swaggerRestService.getTestUserByUserId(id);
        return new ResultInfo.Builder().message("process success").code(HttpStatus.OK.value()).data(userVO).build();
    }
}