package com.kapcb.ccc.swagger;

import java.util.List;

/**
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/3-17:25
 */
public class SwaggerPath {

    //请求路径
    private String path;

    //方法配置
    private List<SwaggerMethod> methods;

    //对象
    private String model;

    //对象-首字母小写
    private String table;

    public SwaggerPath(String Table, String table) {
        this.model = Table;
        this.table = table;
    }

    public SwaggerPath() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SwaggerMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<SwaggerMethod> methods) {
        this.methods = methods;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
