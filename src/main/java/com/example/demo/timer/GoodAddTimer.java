package com.example.demo.timer;

import com.example.demo.good.entity.Good;
import com.example.demo.good.jpa.GoodInfoRepository;
import com.example.demo.good.service.GoodInfoService;
import lombok.SneakyThrows;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 * @author bky
 * @version v1.0 2020/5/26
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/26 bky
 ***/
public class GoodAddTimer extends QuartzJobBean {
    @Autowired
    private GoodInfoRepository goodInfoRepository;

    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        // TODO   业务
        Good good = new Good();
        good.setName("蔬菜水果生鲜0001");
        BigDecimal price = new BigDecimal(10.83);
        good.setPrice(price);
        goodInfoRepository.save(good);
        System.out.println("商品添加完成，任务时间：" + format);
    }
}
