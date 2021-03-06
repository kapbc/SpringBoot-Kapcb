package com.kapcb.ccc.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.kapcb.ccc.service.IEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IEventUpdateHandler </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 19:02
 */
@Slf4j
@Component
public class IEventUpdateHandler implements IEventHandler {
    @Override
    public void handler(CanalEntry.RowData rowData) {

    }
}
