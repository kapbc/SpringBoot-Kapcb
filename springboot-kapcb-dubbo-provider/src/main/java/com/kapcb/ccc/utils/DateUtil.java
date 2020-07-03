package com.kapcb.ccc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <a>Title:DateUtil</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 22:28
 */
public class DateUtil {
    public static final String DATE_FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

    private DateUtil() {
    }

    public static Date StringToDate(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_ONE);
            Date parse = simpleDateFormat.parse(date);
            return parse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
