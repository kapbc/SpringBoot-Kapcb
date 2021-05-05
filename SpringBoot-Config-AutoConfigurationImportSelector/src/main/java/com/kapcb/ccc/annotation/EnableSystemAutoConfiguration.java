package com.kapcb.ccc.annotation;

import com.kapcb.ccc.selector.SystemImportSelector;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <a>Title: EnableSystemAutoConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: Enable System Auto Configuration  <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/4/24 - 17:55
 */
@Inherited
@Documented
@AutoConfigurationPackage
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = {SystemImportSelector.class})
public @interface EnableSystemAutoConfiguration {
}