//package org.dullbird.aop.proxy.demo;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
///**
// * @author cys
// * @date 2018-09-21 下午7:01
// */
//@Component
//@Aspect
//@Order(2)
//public class SpringAopTwo {
//
//    @Around(value = "execution(* org.dullbird.demo.HelloWord.sayHello(..))")
//    public int aroundTwo(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("环绕切点aroundTwo开始");
//        Object proceed = joinPoint.proceed();
//        System.out.println("环绕切点aroundTwo结束");
//        proceed = 7;
//        return Integer.parseInt(proceed.toString());
//    }
//    @AfterReturning(value = "execution(* org.dullbird.demo.HelloWord.sayHello(..))")
//    public void afterReturn() {
//        System.out.println("最后通知Two");
//    }
//
//}
