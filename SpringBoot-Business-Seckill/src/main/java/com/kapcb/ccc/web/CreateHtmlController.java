package com.kapcb.ccc.web;


import com.itstyle.seckill.common.entity.Result;
import com.kapcb.ccc.service.ICreateHtmlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "生成静态商品页")
@RestController
@RequestMapping("/createHtml")
public class CreateHtmlController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CreateHtmlController.class);

    @Autowired
    private ICreateHtmlService createHtmlService;

    @PostMapping("/start")
    @ApiOperation(value = "生成静态商品页", nickname = "科帮网")
    public Result start() {
        LOGGER.info("生成秒杀活动静态页");
        return createHtmlService.createAllHtml();
    }

}
