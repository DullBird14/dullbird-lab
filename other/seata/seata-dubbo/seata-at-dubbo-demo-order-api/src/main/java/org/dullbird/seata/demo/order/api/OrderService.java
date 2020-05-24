package org.dullbird.seata.demo.order.api;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月24日 13:16:00
 */
public interface OrderService {
    Integer createOrder(Long userId, Long productId, Integer price) throws Exception;
    Integer createOrder(Long userId, Long productId, Integer price, Long time) throws Exception;
}
