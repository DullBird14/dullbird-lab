package org.dullbird.design.observer.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RealAction {
    private Object target;
    private Method method;

    public RealAction(Object target, Method method) {
        this.target = target;
        this.method = method;
    }
    public void invoke(Object param) throws InvocationTargetException, IllegalAccessException {
        method.invoke(target, param);
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
