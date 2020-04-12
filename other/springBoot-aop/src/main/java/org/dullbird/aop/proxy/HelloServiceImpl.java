package org.dullbird.aop.proxy;

/**
 * @author cys
 * @date 2019-09-01 8:45 PM
 */

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        System.out.println("say hello!");
        return "实际处理类";
    }
}
