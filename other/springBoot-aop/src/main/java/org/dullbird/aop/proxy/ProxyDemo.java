package org.dullbird.aop.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author cys
 * @date 2019-09-01 8:15 PM
 */

public class ProxyDemo {
    public static void main(String[] args) {
//        cglibDemo();
        jdkDemo();
    }

    public static void jdkDemo() {
        HelloServiceImpl helloService = new HelloServiceImpl();
        ClassLoader classLoader = helloService.getClass().getClassLoader();
        Class<?>[] interfaces = helloService.getClass().getInterfaces();
        LogInvocationHandler logInvocationHandler = new LogInvocationHandler(helloService);
//        LevelTwoInvocationHandler levelTwoInvocationHandler = new LevelTwoInvocationHandler(logInvocationHandler);
        HelloService proxy = (HelloService)Proxy.newProxyInstance(classLoader, interfaces, logInvocationHandler);
        LevelTwoInvocationHandler levelTwoInvocationHandler = new LevelTwoInvocationHandler(proxy);
        proxy = (HelloService)Proxy.newProxyInstance(classLoader, interfaces, levelTwoInvocationHandler);
        proxy.sayHello();
    }

    public static void cglibDemo() {
        LogInterceptor logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceNoInterfaceImpl.class);
        enhancer.setCallback(logInterceptor);

        HelloServiceNoInterfaceImpl helloServiceNoInterface = (HelloServiceNoInterfaceImpl)enhancer.create();
        helloServiceNoInterface.sayHello();
    }


}
