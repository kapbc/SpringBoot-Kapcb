package com.kapcb.ccc;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 20:27
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CanalApplication.class})
public class TestDrivenDevelopment {

    private static final Integer BATCH_SIZE = 1000;

    @Test
    public void testCanal() {
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(
                new InetSocketAddress("192.168.80.131", 11111),
                "test",
                "canal",
                "canal");
        Integer emptyCount = 0;
        Integer totalEmptyCount = 120;
        try {
            canalConnector.connect();
            canalConnector.subscribe(".*\\..*");
            canalConnector.rollback();
            while (emptyCount < totalEmptyCount) {
                // 获取指定数量的数据
                Message message = canalConnector.getWithoutAck(BATCH_SIZE);
                int size = message.getEntries().size();
                long batchId = message.getId();
                if (BATCH_SIZE == 1 || size == 0) {
                    emptyCount++;
                    log.info("the empty count is : " + emptyCount);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        log.error("the thread sleep error!");
                    }
                } else {
                    emptyCount = 0;
                    printEntry(message.getEntries());
                }
                // 手动确认提交
                canalConnector.ack(batchId);
                //处理失败，回滚数据
                // canalConnector.rollback(batchId);
            }
            log.info("empty too many times, exist the program");
        } finally {
            canalConnector.disconnect();
        }
    }

    private void printEntry(List<CanalEntry.Entry> entries) {
        for (CanalEntry.Entry entry : entries) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                log.info("the entry is transactionBegin or transactionEnd");
                continue;
            }
            CanalEntry.RowChange rowChange = null;
            try {
                rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                log.error("parser of eromanga-event has an error, the data is : " + entry.toString(), e);
            }
            CanalEntry.EventType eventType = rowChange.getEventType();
            CanalEntry.Header header = entry.getHeader();
            // binlog
            String logfileName = header.getLogfileName();
            long logfileOffset = header.getLogfileOffset();
            String schemaName = header.getSchemaName();
            String tableName = header.getTableName();
            log.info("=========>the canal info binlog[{} : {}], tableName[{} : {}], eventType : {}",
                    logfileName,
                    logfileOffset,
                    schemaName,
                    tableName,
                    eventType);

            List<CanalEntry.RowData> rowDataList = rowChange.getRowDatasList();
            log.info("the rowDataList is : " + rowDataList);
            log.info("begin to iterator the rowDataList");
            for (CanalEntry.RowData rowData : rowDataList) {
                if (eventType == CanalEntry.EventType.DELETE) {
                    log.info("is delete operator");
                    log.info("the eventType is : " + eventType);
                    log.info("begin to delete the data");
                    List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
                    log.info("the data before delete is : " + beforeColumnsList);
                    for (CanalEntry.Column column : beforeColumnsList) {
                        log.info("the column name is : " + column.getName() + " the value is : " + column.getValue() + " update is : " + column.getUpdated());
                    }
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    log.info("is insert operator");
                    log.info("the eventType is : " + eventType);
                    log.info("begin to insert data");
                    List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
                    log.info("the data after insert is : " + afterColumnsList);
                    for (CanalEntry.Column column : afterColumnsList) {
                        log.info("the column name is : " + column.getName() + " the value is : " + column.getValue() + " update is : " + column.getUpdated());
                    }
                } else if (eventType == CanalEntry.EventType.UPDATE) {
                    log.info("is update operator");
                    log.info("the eventType is : " + eventType);
                    log.info("begin to update data");
                    List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
                    log.info("the data before delete is : " + beforeColumnsList);
                    for (CanalEntry.Column column : beforeColumnsList) {
                        log.info("the column name is : " + column.getName() + " the value is : " + column.getValue() + " update is : " + column.getUpdated());
                    }
                    List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
                    log.info("the data after insert is : " + afterColumnsList);
                    for (CanalEntry.Column column : beforeColumnsList) {
                        log.info("the column name is : " + column.getName() + " the value is : " + column.getValue() + " update is : " + column.getUpdated());
                    }
                }
            }
        }
    }
}
