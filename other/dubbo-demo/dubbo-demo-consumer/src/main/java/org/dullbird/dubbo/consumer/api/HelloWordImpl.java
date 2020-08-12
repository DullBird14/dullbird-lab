package org.dullbird.dubbo.consumer.api;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月12日 15:50:00
 */
public class HelloWordImpl implements HelloWordApi {
    @Override
    public String say() {
        return "hello, this is consumer hello!";
    }
}
