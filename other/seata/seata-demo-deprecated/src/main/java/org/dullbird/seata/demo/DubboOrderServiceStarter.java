package org.dullbird.seata.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月22日 22:51:00
 */
public class DubboOrderServiceStarter {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws InterruptedException {
        /**
         *  3. Order service is ready . Waiting for buyers to order
         */
        CountDownLatch latch = new CountDownLatch(1);
        ClassPathXmlApplicationContext orderContext = new ClassPathXmlApplicationContext(
                new String[] {"spring/dubbo-order-service.xml"});
        orderContext.getBean("service");
        System.out.println("==================start success====================");
        latch.await();
    }
}
