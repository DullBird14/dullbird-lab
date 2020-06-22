package org.dullbird.design.strategy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月22日 00:07:00
 */
@Data
@Accessors(chain = true)
public class Order {
    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    // ...其他的一些字段
}
