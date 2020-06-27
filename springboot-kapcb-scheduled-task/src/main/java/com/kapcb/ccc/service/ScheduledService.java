package com.kapcb.ccc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <a>Title:ScheduledService</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/27 23:05
 */
@Service
public class ScheduledService {

    /**
     * cron：second(秒)、minute(分)、hour(时)、day of month(日)、month(月)、day of week(周)
     * 0 * * * * MON-FRI
     * 表达式一共6位，以空格分隔分别代表：second(秒)、minute(分)、hour(时)、day of month(日)、month(月)、day of week(周)
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("定时任务hello执行力..." + date);
    }

}
