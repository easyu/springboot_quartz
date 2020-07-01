package com.example.demo.good.controller;

import com.example.demo.good.entity.Good;
import com.example.demo.good.service.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author bky
 * @version v1.0 2020/5/26
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/26 bky
 ***/
@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodInfoService goodInfoService;

    @GetMapping("/save")
    public Long save(Good good) throws Exception {
        return goodInfoService.saveGood(good);
    }
}
