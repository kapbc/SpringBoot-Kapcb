package com.kapcb.ccc.build;

import java.util.Map;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
public class SwaggerBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //swagger的文件名字
        modelMap.put("Table", "template/swagger");

        //生成ServiceImpl层文件
        BuilderFactory.builder(modelMap,
                "/template/swagger",
                "swagger.json",
                TemplateBuilder.SWAGGERUI_PATH,
                ".json");
    }
}
