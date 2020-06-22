package org.dullbird.design.strategy.annotation;

import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月22日 20:51:00
 */
public class HandlerTypeImpl implements HandlerType{
    private String type;
    private String method;

    public HandlerTypeImpl(String type, String method) {
        this.type = type;
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public String method() {
        return method;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HandlerTypeImpl that = (HandlerTypeImpl) o;
//        return Objects.equals(type, that.type) &&
//                Objects.equals(method, that.method);
//    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HandlerType)) {
            return false;
        }
        HandlerType that = (HandlerType) o;
        return type.equals(that.type())
                && method.equals(that.method());

    }
    @Override
    public int hashCode() {
        int var1 = 0;
        var1 += (127 * "type".hashCode()) ^ type.hashCode();
        var1 += (127 * "method".hashCode()) ^ method.hashCode();
        return var1;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return HandlerType.class;
    }
}
