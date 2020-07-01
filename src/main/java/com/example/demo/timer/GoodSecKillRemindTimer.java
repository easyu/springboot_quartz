package com.example.demo.timer;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/***
 *
 * @author bky
 * @version v1.0 2020/5/27
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/27 bky
 ***/
public class GoodSecKillRemindTimer extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取任务详情内的数据集合
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        // 获取商品编号
        long goodId = jobDataMap.getLong("goodId");
        System.out.println("开始抢购" + goodId + "号物品");
    }
}
