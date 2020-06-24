package com.kapcb.ccc.common;

/**
 * <a>Title:ResponseMessage</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * 承载服务器返回给浏览器的消息
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/14 21:42
 */
public class ResponseMessage {

    private String responseMessage;

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
