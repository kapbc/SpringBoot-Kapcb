package com.kapcb.ccc.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <a>Title:MyFirstJob</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/30 20:56
 */
public class MyFirstJob implements Job {
    /**
     * 任务执行器
     *
     * @param context JobExecutionContext
     * @throws JobExecutionException JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //任务详情
        JobDetail jobDetail = context.getJobDetail();

        //任务名称
        String name = jobDetail.getKey().getName();
        //任务分组
        String group = jobDetail.getKey().getGroup();
        //任务数据
        String data = jobDetail.getJobDataMap().getString("data");
    }
}
