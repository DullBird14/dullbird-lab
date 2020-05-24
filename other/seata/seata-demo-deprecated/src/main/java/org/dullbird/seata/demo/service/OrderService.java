package org.dullbird.seata.demo.service;

import org.dullbird.seata.demo.entity.Order;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月22日 23:29:00
 */
public interface OrderService {
    /**
     * create order
     */
    Order create(String userId, String commodityCode, int orderCount);
}