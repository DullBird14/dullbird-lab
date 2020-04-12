package org.dullbird.aop.proxy.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author cys
 * @date 2018-09-21 下午7:01
 */
@Component
@Aspect
@Order(1)
public class SpringAop {

    @Around(value = "execution(* org.dullbird.aop.proxy.demo.Client.hello(..))")
    public int around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕切点开始");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕切点结束");
        proceed = 5;
        return Integer.parseInt(proceed.toString());
    }

    @AfterReturning(value = "execution(* org.dullbird.aop.proxy.demo.Client.hello(..))")
    public void afterReturn() {
        System.out.println("最后通知One");
    }
//    @Before("execution(* org.dullbird.demo.HelloWord.sayHello(..))")
//    public void before(){
//        System.out.println("前置通知！！！！！");
////        return 1;
//    }
//
//    @AfterThrowing("execution(* org.dullbird.demo.HelloWord.sayHello(..))")
//    public int afterException(){
//        System.out.println("异常出发！！！！！");
//        return -1;
//    }
//
//    @AfterReturning(value = "execution(int org.dullbird.demo.HelloWord.sayHello())"
//            , returning = "argments")
//    public int afterReturn(int argments){
//        System.out.println("返回切点！！！！！返回值" + argments);
//
//        return 5;
//    }
//匹配org.dullbird.demo包下及其子包下的所有类的方法
//    @Before(value = "within(org.dullbird.demo..*)")
//匹配org.dullbird.demo.HelloWord类中的所有方法
//    @Before(value = "within(org.dullbird.demo.HelloWord)")
//匹配HelloWord类及其所有子类的方法。HelloWord也可以是接口
//    @Before(value = "within(org.dullbird.demo.HelloWord+)")

//
//    @Before(value = "within(org.dullbird.demo.*)")
//    public void withinTest(){
//        System.out.println("within 匹配标签");
//    }
}
