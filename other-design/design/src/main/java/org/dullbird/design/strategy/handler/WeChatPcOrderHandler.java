package org.dullbird.design.strategy.handler;

import org.dullbird.design.strategy.Order;
import org.dullbird.design.strategy.annotation.HandlerType;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月22日 00:10:00
 */
@HandlerType(type = "pc", method = "weChat")
public class WeChatPcOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println(" 微信pc订单处理");
    }
}
