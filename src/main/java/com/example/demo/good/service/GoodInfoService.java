package com.example.demo.good.service;

import com.example.demo.good.entity.Good;
import com.example.demo.good.jpa.GoodInfoRepository;
import com.example.demo.timer.GoodAddTimer;
import com.example.demo.timer.GoodStockCheckTimer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/***
 *
 * @author bky
 * @version v1.0 2020/5/26
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/26 bky
 ***/
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodInfoService {
    /**
     * 注入任务调度器
     */
    @Autowired
    private Scheduler scheduler;
    /**
     * 商品数据接口
     */
    @Autowired
    private GoodInfoRepository goodInfoRepository;

    /**
     * @param good
     * @return
     * @throws Exception
     */
    public Long saveGood(Good good) throws Exception {
        goodInfoRepository.save(good);
        buildCreateGoodTimer();
        buildGoodStockTimer();
        return good.getId();
    }

    /**
     * 创建商品定时任务
     * 定时任务只运行一次的
     */
    public void buildCreateGoodTimer() throws Exception {
        //设置开始时间为1分钟后
        Long startTime = System.currentTimeMillis() + 1000 * 60;
        //随机生成的任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = GoodAddTimer.class.getName();
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodAddTimer.class)
                .withIdentity(name, group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
                .startAt(new Date(startTime)).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);

    }

    /**
     * 商品库存定时任务
     *
     * @throws SchedulerException
     */
    public void buildGoodStockTimer() throws SchedulerException {
        //随机任务名称
        String name = UUID.randomUUID().toString();
        // 分配任务组
        String group = GoodStockCheckTimer.class.getName();
        // cron表达式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodStockCheckTimer.class).
                withIdentity(name, group).build();
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(name, group).withSchedule(scheduleBuilder).build();
        // 将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
