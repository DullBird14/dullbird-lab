package org.dullbird.aop.proxy;

/**
 * @author cys
 * @date 2019-09-01 8:53 PM
 */

public class HelloServiceNoInterfaceImpl {
    public String sayHello() {
        System.out.println("没有接口的实现类");
        return "没有接口的实现类";
    }
}
