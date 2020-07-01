package com.example.demo.timer;

import com.example.demo.good.service.GoodInfoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 * @author bky
 * @version v1.0 2020/5/27
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/27 bky
 ***/
public class GoodStockCheckTimer extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        System.out.println("定时检查库存   " + format);
    }
}
