//package org.dullbird.design.strategy;
//
//import org.dullbird.design.strategy.annotation.HandlerType;
//import org.dullbird.design.strategy.handler.OrderHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @author dullBird
// * @version 1.0.0
// * @createTime 2020年06月22日 00:08:00
// */
//@Service
//public class OrderServiceImpl {
//    private Map<String, OrderHandler> orderHandleMap;
//
//    @Autowired
//    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
//        // 注入各种类型的订单处理类
//        orderHandleMap = orderHandlers.stream().collect(
//                Collectors.toMap(orderHandler -> AnnotationUtils
//                                .findAnnotation(orderHandler.getClass(),
//                                        HandlerType.class).type(),
//                        v -> v, (v1, v2) -> v1));
//    }
//
//    public void processOrder(Order order) {
//        String source = order.getSource();
//        OrderHandler orderHandler = orderHandleMap.get(source);
//        orderHandler.handle(order);
//    }
//}
