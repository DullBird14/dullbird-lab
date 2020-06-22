package org.dullbird.design.strategy.handler;

import org.dullbird.design.strategy.Order;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月22日 00:09:00
 */
public interface OrderHandler {
    void handle(Order order);
}
