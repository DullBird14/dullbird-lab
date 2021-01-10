package org.dullbird.aop.proxy.geekbang;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TwoProxy {
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
        //可以指定接口
//        enhancer.setInterfaces(new Class[]{HelloService.class});
        //指定父类，就是我们的实现类
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                //如果调用method的话会无限递归
                System.out.println("cglib proxy;");
                return methodProxy.invokeSuper(object, objects);
            }
        });

        HelloService cglibHello = (HelloService) enhancer.create();
        cglibHello.sayHello();

    }
}
