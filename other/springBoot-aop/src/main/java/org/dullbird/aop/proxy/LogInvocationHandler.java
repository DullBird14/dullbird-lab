package org.dullbird.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cys
 * @date 2019-09-01 8:40 PM
 */

public class LogInvocationHandler implements InvocationHandler {
    Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doLogBefore();
        Object result = method.invoke(target, args);
        doLogAfter();
        return result;
    }

    private void doLogBefore() {
        System.out.println("代理写入日志:before");
    }

    private void doLogAfter() {
        System.out.println("代理日志:after");
    }
}
