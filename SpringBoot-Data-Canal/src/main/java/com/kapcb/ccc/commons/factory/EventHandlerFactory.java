package com.kapcb.ccc.commons.factory;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.kapcb.ccc.commons.constants.CanalConstants;
import com.kapcb.ccc.service.IEventHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: EventHandlerFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 19:00
 */
@Slf4j
public class EventHandlerFactory {

    private static final int INITIAL_CAPACITY = 16;
    private static final String COMMON_UNION_SPILT = "-";

    private static final Map<String, IEventHandler> EVENT_HANDLER_MAP = new HashMap<>(INITIAL_CAPACITY);

    public void setEventHandler(String key, IEventHandler iEventHandler) {
        EVENT_HANDLER_MAP.put(key, iEventHandler);
    }

    public IEventHandler getEventHandler(String key) {
        return EVENT_HANDLER_MAP.getOrDefault(key, null);
    }

    public static String createUnionKey(TableInfo tableInfo, CanalEntry.EventType eventType) {
        return createUnionKey(tableInfo.getDatabaseName(), tableInfo.getTableName(), eventType);
    }

    public static String createUnionKey(CanalEntry.EventType eventType) {
        return createUnionKey(CanalConstants.UNITY_SCHEMA, CanalConstants.UNITY_TABLE, eventType);
    }

    private static String createUnionKey(String databaseName, String tableName, CanalEntry.EventType eventType) {
        log.info("begin to create union key");
        StringBuilder unionKey = new StringBuilder();
        unionKey.append(databaseName).append(COMMON_UNION_SPILT);
        unionKey.append(tableName).append(COMMON_UNION_SPILT);
        unionKey.append(eventType.getValueDescriptor().getName());
        log.info("union key create success, the unionKey is : " + unionKey.toString());
        return unionKey.toString();
    }

}
