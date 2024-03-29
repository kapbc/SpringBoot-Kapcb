package com.kapcb.ccc.commons.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: ApplicationRunner </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RabbitMq Producer Application Runner <a>
 *
 * @author Kapcb
 * @date 2021/4/19-20:22
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMqProducerApplicationRunner implements ApplicationRunner {

    private static final String SERVER_PORT = "server.port";
    private static final String SERVER_NAME = "spring.application.name";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ssS");

    private final Environment environment;
    private final ConfigurableApplicationContext applicationContext;

    @Async
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (applicationContext.isActive()) {
            rabbitProducerServiceBanner(environment);
        }
    }

    private static void rabbitProducerServiceBanner(Environment environment) {
        String banner = "----------------------------------------------------------------------------------\n" +
                "rabbit producer service start up success, current local date time : " + DATE_TIME_FORMATTER.format(LocalDateTime.now()) + "\n" +
                "server name : " + environment.getProperty(SERVER_NAME) + "\n" +
                "server port : " + environment.getProperty(SERVER_PORT) + "\n" +
                "----------------------------------------------------------------------------------";
        System.out.println(banner);
    }
}
