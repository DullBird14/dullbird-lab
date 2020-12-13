package org.dullbird.aop.proxy.geekbang;

public class DefaultHelloStaticProxy implements HelloService {
    private HelloService helloService = new HelloServiceImpl();

    @Override
    public void sayHello() {
        System.out.println("static proxy!!!");
        helloService.sayHello();
    }

    public static void main(String[] args) {
        DefaultHelloStaticProxy staticProxy = new DefaultHelloStaticProxy();
        staticProxy.sayHello();
    }
}
