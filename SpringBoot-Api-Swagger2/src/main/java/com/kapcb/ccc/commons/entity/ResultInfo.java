package com.kapcb.ccc.commons.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 15:49
 */
public class ResultInfo extends HashMap<String, Object> {

    private static final String RETURN_CODE = "code";
    private static final String RETURN_DATA = "data";
    private static final String RETURN_MESSAGE = "message";

    private int code;
    private Object data;
    private String message;

    public ResultInfo() {
    }

    public ResultInfo(String message, int code) {
        put(RETURN_MESSAGE, message);
        put(RETURN_CODE, code);
    }

    public ResultInfo(String message, int code, Object data) {
        put(RETURN_MESSAGE, message);
        put(RETURN_CODE, code);
        put(RETURN_DATA, data);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    @Override
    public Object get(Object key) {
        return super.get(key);
    }

    public static class Builder {
        private static final int INITIAL_CAPACITY = 6;

        private final Map<String, Object> returnMessage = new HashMap<>(INITIAL_CAPACITY);

        public Builder() {
        }

        public ResultInfo.Builder message(String message) {
            returnMessage.put(RETURN_MESSAGE, message);
            return this;
        }

        public ResultInfo.Builder code(int code) {
            returnMessage.put(RETURN_CODE, code);
            return this;
        }

        public ResultInfo.Builder data(Object data) {
            returnMessage.put(RETURN_DATA, data);
            return this;
        }

        public ResultInfo.Builder put(String key, String value) {
            returnMessage.put(key, value);
            return this;
        }

        public Map<String, Object> build() {
            return returnMessage;
        }
    }
}