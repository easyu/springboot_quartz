package com.example.demo.good.jpa;

import com.example.demo.good.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 * @author bky
 * @version v1.0 2020/5/26
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/26 bky
 ***/
public interface GoodInfoRepository extends JpaRepository<Good, Long> {
}
