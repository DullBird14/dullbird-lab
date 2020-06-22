package org.dullbird.design.strategy.handler;

import org.dullbird.design.strategy.Order;
import org.dullbird.design.strategy.annotation.HandlerType;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月22日 00:10:00
 */
@HandlerType(type = "pc")
public class PcOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println(" 处理pc订单");
    }
}
