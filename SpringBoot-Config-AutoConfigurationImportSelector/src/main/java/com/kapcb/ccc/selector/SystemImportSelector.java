package com.kapcb.ccc.selector;

import com.kapcb.ccc.component.AutoConfigurationComponentOne;
import com.kapcb.ccc.component.AutoConfigurationComponentTwo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <a>Title: KapcbImportSelector </a>
 * <a>Author: kapcb <a>
 * <a>Description: System Import Selector <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 17:51
 */
public class SystemImportSelector implements ImportSelector {

    /**
     * 声明一个ImportSelector实现类, 将声明的两个Bean加入String数组中
     * 这意味着这两个Bean都将会装配到Spring的IOC容器中
     * <p>
     * 当然也可以同时注入多个配置类, 进行批量配置注入
     *
     * @param annotationMetadata AnnotationMetadata
     * @return String[] Class Name
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{AutoConfigurationComponentOne.class.getName(), AutoConfigurationComponentTwo.class.getName()};
    }

}
