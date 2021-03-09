package com.globalsources.cannal.test;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.DeleteListenPoint;
import com.xpand.starter.canal.annotation.InsertListenPoint;
import com.xpand.starter.canal.annotation.UpdateListenPoint;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <a>Title: CanalTest </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-16:22
 */
@Slf4j
@CanalEventListener
public class CanalTest {

    @UpdateListenPoint
    public void canalUpdateListener(CanalEntry.EntryType entryType, CanalEntry.RowData rowData) {
        log.info("come into canal update listener");
        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        log.info("the data before update is : " + beforeColumnsList);
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        log.info("the data after update is : " + afterColumnsList);
    }

    @InsertListenPoint
    public void canalInsertListener(CanalEntry.EntryType entryType, CanalEntry.RowData rowData) {
        log.info("come into canal insert listener");
        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        log.info("the data before update is : " + beforeColumnsList);
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
        log.info("the data after update is : " + afterColumnsList);
    }

    @DeleteListenPoint
    public void canalDeleteListener(CanalEntry.EntryType entryType, CanalEntry.RowData rowData) {
        log.info("come into canal delete listener");
        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        log.info("the data before update is : " + beforeColumnsList);
    }
}
