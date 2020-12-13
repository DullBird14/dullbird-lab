package org.dullbird.aop.proxy.geekbang;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        HelloServiceImpl helloService = new HelloServiceImpl();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk proxy!!!");
                return method.invoke(helloService, args);
            }
        };
        HelloService jdkHello = (HelloService) Proxy.newProxyInstance(contextClassLoader,
                    new Class[]{HelloService.class}, handler);
        jdkHello.sayHello();

        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{HelloService.class});
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib proxy;");
                return methodProxy.invokeSuper(object, objects);
            }
        });

        HelloService cglibHello = (HelloService) enhancer.create();
        cglibHello.sayHello();

    }
}
