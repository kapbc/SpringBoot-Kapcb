package com.kapcb.ccc;

import com.kapcb.ccc.annotation.EnableSystemAutoConfiguration;
import com.kapcb.ccc.component.AutoConfigurationComponentOne;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <a>Title: AutoConfigurationImportSelectorApplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: Auto Configuration Import Selector <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 17:46
 */
@SpringBootApplication
@EnableSystemAutoConfiguration
public class AutoConfigurationImportSelectorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
                .sources(AutoConfigurationImportSelectorApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);

        AutoConfigurationComponentOne bean = applicationContext.getBean(AutoConfigurationComponentOne.class);
        bean.hello();
    }
}