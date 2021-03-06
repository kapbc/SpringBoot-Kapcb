package com.kapcb.ccc.commons.event;

import lombok.Getter;

/**
 * <a>Title: EventTable </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 18:58
 */
@Getter
public class TableInfo {

    /**
     * 数据库名称
     */
    private String databaseName;

    /**
     * 表名
     */
    private String tableName;

    public TableInfo(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
    }
}
