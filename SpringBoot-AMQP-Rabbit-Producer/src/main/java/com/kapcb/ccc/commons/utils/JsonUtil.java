package com.kapcb.ccc.commons.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 12:28
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    private static final String EMPTY_RETURN_VALUE = "{}";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * convert object to json string
     *
     * @param object T
     * @param <T>    <T>
     * @return String
     */
    public static <T> String convertObjectToString(T object) {
        if (Objects.equals(null, object)) {
            return EMPTY_RETURN_VALUE;
        }
        String convertResult = null;
        try {
            return object instanceof String ? (String) object : OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return EMPTY_RETURN_VALUE;
        }
    }

    /**
     * convert amqp message to object bean
     *
     * @param bytes byte[]
     * @param clazz Class<? extends T>
     * @param <T>   <T>
     * @return T
     */
    public static <T> T convertByteArrayToObject(byte[] bytes, Class<? extends T> clazz) {
        if (Objects.equals(null, bytes)) {
            return null;
        }
        try {
            return Objects.equals(String.class, clazz) ? (T) new String(bytes) : OBJECT_MAPPER.readValue(bytes, clazz);
        } catch (IOException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    public static <T> String convertObjectToStringPretty(T object) {
        if (Objects.equals(null, object)) {
            return null;
        }
        String convertResult = null;
        try {
            return object instanceof String ? (String) object : OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * convert json string to object
     *
     * @param jsonString String
     * @param clazz      Class<T>
     * @param <T>        <T>
     * @return String
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertStringToObject(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString) || clazz == null) {
            return null;
        }
        T convertResult = null;
        try {
            return Objects.equals(clazz, String.class) ? (T) jsonString : OBJECT_MAPPER.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * jsonString convert to collection object
     *
     * @param jsonString    String
     * @param typeReference TypeReference<T>
     * @param <T>           <T>
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertStringToObject(String jsonString, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(jsonString) || typeReference == null) {
            return null;
        }
        try {
            return Objects.equals(typeReference.getType(), String.class) ? (T) jsonString : OBJECT_MAPPER.readValue(jsonString, typeReference);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * jsonString convert to collection object
     *
     * @param jsonString      String
     * @param collectionClass Class<?>
     * @param elementClasses  Class<?>
     * @param <T>             <T>
     * @return T
     */
    public static <T> T convertStringToObject(String jsonString, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return OBJECT_MAPPER.readValue(jsonString, javaType);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * Map builder
     */
    public static class JsonBuilder {
        private final Map<String, Object> builderMap = new HashMap<>(16);

        public JsonBuilder() {
        }

        public JsonUtil.JsonBuilder put(String key, Object value) {
            builderMap.put(key, value);
            return this;
        }

        public String builder() {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(this.builderMap);
            } catch (JsonProcessingException e) {
                log.error("json process error, the exception is : " + e.getMessage(), e);
            }
            return "{}";
        }
    }
}