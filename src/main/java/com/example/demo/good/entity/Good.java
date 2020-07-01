package com.example.demo.good.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/***
 *
 * @author bky
 * @version v1.0 2020/5/26
 * 历史记录
 *    版本     时间     姓名   更新内容
 *   v1.0   2020/5/26 bky
 ***/
@Entity
@Table(name = "basic_good_info")
@Data
public class Good {
    /**
     * 商品编号
     */
    @Id
    @GeneratedValue
    @Column(name = "bgi_id")
    private long id;
    /**
     * 商品名称
     */
    @Column(name = "bgi_name")
    private String name;
    /**
     * 商品价格
     */
    @Column(name = "bgi_price")
    private BigDecimal price;
}
