package com.kapcb.ccc.service;

import com.alibaba.otter.canal.protocol.CanalEntry;

/**
 * <a>Title: IEventHandler </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 19:01
 */
public interface IEventHandler {

    void handler(CanalEntry.RowData rowData);

}
