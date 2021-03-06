package com.kapcb.ccc.commons.context;

import com.kapcb.ccc.service.IEventHandler;
import com.oracle.jrockit.jfr.EventInfo;

/**
 * <a>Title: EventHandlerContext </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/6 19:06
 */
public class EventHandlerContext {

    private IEventHandler eventHandler;

    private EventInfo eventInfo;

    public EventHandlerContext(IEventHandler eventHandler, EventInfo eventInfo) {
        this.eventInfo = eventInfo;
        this.eventHandler = eventHandler;
    }

    public void setEventHandler(IEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void handler() {
        this.eventHandler.handler(eventInfo.getRowData());
    }
}
