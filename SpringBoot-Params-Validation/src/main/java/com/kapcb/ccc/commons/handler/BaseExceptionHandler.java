package com.kapcb.ccc.commons.handler;

import com.kapcb.ccc.commons.entity.ResultInfo;
import com.kapcb.ccc.commons.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a>Title: GlobalExceptionHandler </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/14 14:23
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerException(Exception e) {
        log.error("handler exception in BaseExceptionHandler, the error message is ： " + e.getMessage());
        return new ResultInfo
                .Builder()
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data("")
                .build();
    }

    @ExceptionHandler(value = SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerSystemException(SystemException e) {
        log.error("handler SystemException in BaseExceptionHandler, the error message is ： " + e.getMessage());
        return new ResultInfo
                .Builder()
                .message(e.getMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data("")
                .build();
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return Map<String, Object>
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            message.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(" ,");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.info("the bind error message is : " + message.toString());
        return new ResultInfo
                .Builder()
                .message(message.toString())
                .code(HttpStatus.BAD_REQUEST.value())
                .data("")
                .build();
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return Map<String, Object>
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerConstrainViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            Path propertyPath = constraintViolation.getPropertyPath();
            String[] pathArrays = StringUtils.splitByWholeSeparatorPreserveAllTokens(propertyPath.toString(), ".");
            message.append(pathArrays[1]).append(constraintViolation.getMessage()).append(", ");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.info("the ConstraintViolationException error message is : " + message.toString());
        return new ResultInfo
                .Builder()
                .message(message.toString())
                .code(HttpStatus.BAD_REQUEST.value())
                .data("")
                .build();
    }

    /**
     * 统一处理请求参数校验(json)
     *
     * @param e MethodArgumentNotValidException
     * @return Map<String, Object>
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            message.append(fieldError.getField()).append(fieldError.getDefaultMessage()).append(" ,");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.info("the MethodArgumentNotValidException error message is : " + message.toString());
        return new ResultInfo.Builder()
                .message(message.toString())
                .code(HttpStatus.BAD_REQUEST.value())
                .data("")
                .build();

    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        StringBuilder message = new StringBuilder();
        message.append("该方法不支持");
        message.append(StringUtils.substringBetween(e.getMessage(), "'", "'"));
        message.append(" 媒体类型");
        log.info("the HttpMediaTypeNotSupportedException error message is : " + message.toString());
        return new ResultInfo.Builder()
                .message(message.toString())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data("")
                .build();
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        StringBuilder message = new StringBuilder();
        message.append("该方法不支持");
        message.append(StringUtils.substringBetween(e.getMessage(), "'", "'"));
        message.append(" 方法请求");
        log.info("the HttpRequestMethodNotSupportedException error message is : " + message.toString());
        return new ResultInfo.Builder()
                .message(message.toString())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .data("")
                .build();
    }
}
