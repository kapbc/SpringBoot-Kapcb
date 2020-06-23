package com.kapcb.ccc.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * <a>Title:MyErrorAttributes</a>
 * <a>Author：<a>
 * <a>Description：<a>
 * <p>
 * 给容器中加入自定义的 ErrorAttributes
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/23 14:46
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 这个返回的Map<String, Object>就是页面和json能获取的所有字段
     *
     * @param webRequest WebRequest是RequestAttributes的子类，RequestAttributes是对 request的包装
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("author", "kapcb");
        //getAttribute中传入两个参数：取出的key，作用域
        //异常处理器中携带的数据
        Map<String, Object> etx = (Map<String, Object>) webRequest.getAttribute("etx", RequestAttributes.SCOPE_REQUEST);
        map.put("etx", etx);
        return map;
    }
}
