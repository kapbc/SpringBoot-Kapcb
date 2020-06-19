package com.kapcb.ccc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootKapcbLogApplicationTests {

    //记录器
    Logger logger  = LoggerFactory.getLogger(getClass());

    @Test
    public void test(){
        /**
         * 日志的级别
         * 由低到高 trace —> debug —> info —> warn —> error
         *
         * 可以调整输出的日志级别，如系统上线了只想看什么级别的日志
         * 调整之后，日志就只会在这个级别之后的高级级别生效
         * 例如调整为debug级别 就只会 debug —> info —> warn —> error
         */
        logger.trace("trace：跟踪轨迹信息");
        logger.debug("debug：调试日志");
        /**
         * SpringBoot默认的日志级别为 info
         */
        logger.info("info：自定义信息日志");
        logger.warn("warn：警告日志");
        logger.error("error：捕获异常");
    }
}
