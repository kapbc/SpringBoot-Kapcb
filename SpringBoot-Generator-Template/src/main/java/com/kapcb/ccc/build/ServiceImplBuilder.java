package com.kapcb.ccc.build;

import java.util.Map;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
public class ServiceImplBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成ServiceImpl层文件
        BuilderFactory.builder(modelMap,
                "/template/service/impl",
                "ServiceImpl.java",
                TemplateBuilder.PACKAGE_SERVICE_INTERFACE_IMPL,
                "ServiceImpl.java");
    }

}
