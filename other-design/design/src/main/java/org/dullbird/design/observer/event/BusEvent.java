package org.dullbird.design.observer.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class BusEvent {
    ConcurrentHashMap<Class, CopyOnWriteArraySet<RealAction>> subscribeMap;
    public BusEvent() {
        subscribeMap = new ConcurrentHashMap<>();
    }
    public void post(Object object) throws Exception {
        Class<?> paramClass = object.getClass();
        for (Map.Entry<Class, CopyOnWriteArraySet<RealAction>> entry : subscribeMap.entrySet()) {
            if (!entry.getKey().isAssignableFrom(paramClass)) {
                continue;
            }
            for (RealAction realAction : entry.getValue()) {
                realAction.invoke(object);
            }
        }

    }

    public void register(Object target) {
        Class<?> targetClass = target.getClass();
        Method[] declaredMethods = targetClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Subscribe annotation = declaredMethod.getAnnotation(Subscribe.class);
            if (Objects.nonNull(annotation)) {
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                Class<?> parameterType = parameterTypes[0];
                subscribeMap.putIfAbsent(parameterType, new CopyOnWriteArraySet<>());
                CopyOnWriteArraySet<RealAction> realActions = subscribeMap.get(parameterType);
                realActions.add(new RealAction(target, declaredMethod));
            }
        }
    }
}
