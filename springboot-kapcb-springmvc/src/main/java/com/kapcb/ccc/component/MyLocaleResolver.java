package com.kapcb.ccc.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * <a>Title:MyLocaleResolver</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/21 13:58
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析区域信息
     *
     * @param request
     * @return Locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        /**
         * 如果没带则使用系统默认的
         */
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            /**
             * l='zh_CN'
             * l='en_US'
             */
            String[] s = l.split("_");
            /**
             * new Locale(language, country):两个参数的构造器，第一个值为语言信息，第二个值为国家信息
             */
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    /**
     * 设置区域信息
     *
     * @param request
     * @param response
     * @param locale
     */
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
