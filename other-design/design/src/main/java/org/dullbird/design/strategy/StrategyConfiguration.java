//package org.dullbird.design.strategy;
//
//import org.dullbird.design.strategy.annotation.HandlerType;
//import org.dullbird.design.strategy.handler.MobileOrderHandler;
//import org.dullbird.design.strategy.handler.OrderHandler;
//import org.dullbird.design.strategy.handler.PcOrderHandler;
//import org.springframework.cglib.core.DebuggingClassWriter;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author dullBird
// * @version 1.0.0
// * @createTime 2020年06月22日 19:57:00
// */
//@Configuration
//@ComponentScan
//public class StrategyConfiguration {
//    public static void main(String[] args) {
//        //打印代理对象
////        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
////        HandlerType annotation = PcOrderHandler.class.getAnnotation(HandlerType.class);
////        System.out.println(annotation.type());
//
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
//                "/Users/user01/workcontext/idea/learnSpace/dullbird-lab/other-design/design/build/proxy/");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                StrategyConfiguration.class);
//        OrderServiceImpl bean = context.getBean(OrderServiceImpl.class);
//        bean.processOrder(new Order().setSource("pc"));
//
//        OrderObjectServiceImpl objectBean = context.getBean(OrderObjectServiceImpl.class);
//        objectBean.processOrder(new Order().setSource("pc").setPayMethod("weChat"));
//        context.close();
//    }
//}
