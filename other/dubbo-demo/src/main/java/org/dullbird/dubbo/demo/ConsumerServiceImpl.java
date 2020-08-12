package org.dullbird.dubbo.demo;

import org.dullbird.dubbo.consumer.api.HelloWordApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月12日 15:56:00
 */
@RestController
public class ConsumerServiceImpl {
    @Autowired
    @Qualifier("HelloWordApiImpl")
    private HelloWordApi helloWordApi;

    @GetMapping("/api/test")
    public String test() {
        return helloWordApi.say();
    }
}
