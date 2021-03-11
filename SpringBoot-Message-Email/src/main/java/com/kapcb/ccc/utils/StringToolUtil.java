package com.kapcb.ccc.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a>Title: StringToolUtil </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/8-18:54
 */
@Slf4j
public class StringToolUtil {

    private static final int INITIAL_CAPACITY = 4;

    private static final String YEAR_MONTH_DAY_HOUR_MINUTE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final Map<String, DateFormat> FORMATTER_MAP = new HashMap<>(INITIAL_CAPACITY);

    private static NumberFormat numberFormat;

    private StringToolUtil() {
    }

    public static boolean isNull(Object object) {
        log.info("the object is : " + object);
        return object == null;
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            log.info("object is null");
            return true;
        } else if (object instanceof List) {
            log.info("the object is a List");
            return ((List) object).isEmpty();
        } else if (object instanceof Map) {
            log.info("the object is Map");
            return ((Map) object).isEmpty();
        } else {
            return object.toString().trim().length() == 0;
        }
    }

    public static String doubleToString(double object, int maxFractionDigits) {
        log.info("the object is : " + object + " the maxFractionDigits is : " + maxFractionDigits);
        NumberFormat numberFormat = getDoubleFormat(false, maxFractionDigits);
        synchronized (numberFormat) {
            return numberFormat.format(object);
        }
    }

    public static String asString(Object object, int maxLength) {
        if (isNull(object)) {
            return null;
        } else if (isEmpty(object)) {
            return "";
        } else if (object instanceof Date) {
            return dateToString((Date) object);
        }else if (object instanceof Double){
            return doubleToString(((Double) object).doubleValue(), 6);
        }else {
            try {

            }
        }
    }

    public static String dateToString(Date date) {
        log.info("the date is : " + date);

    }

    private static NumberFormat getDoubleFormat(boolean showGroup, int maxFractionDigits) {
        log.info("the showGroup is : " + showGroup + " the maxFractionDigits is : " + maxFractionDigits);
        if (numberFormat == null) {
            log.info("the numberFormat is null, begin to get the instance");
            numberFormat = NumberFormat.getNumberInstance();
        }

        numberFormat.setGroupingUsed(showGroup);
        numberFormat.setMaximumFractionDigits(maxFractionDigits);
        return numberFormat;
    }

    public static String ReadXlobString(Object xlob){
        StringBuffer result = new StringBuffer();
        BufferedReader reader=null;
        xlob instanceof 
    }


}
