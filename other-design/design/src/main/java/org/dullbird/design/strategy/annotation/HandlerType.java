package org.dullbird.design.strategy.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月22日 19:52:00
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface HandlerType {
    String type() default "";
    String method() default "";
}
