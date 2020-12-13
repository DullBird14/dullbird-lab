package org.dullbird.aop.proxy.geekbang;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("real method say hello!");
    }
}
