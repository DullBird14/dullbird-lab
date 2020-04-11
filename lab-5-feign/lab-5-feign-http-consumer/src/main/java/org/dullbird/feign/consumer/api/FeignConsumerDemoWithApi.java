package org.dullbird.feign.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 17:41:00
 */
@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignConsumerDemoWithApi {

    @Autowired
    private DemoProviderFeignClientWithApi demoProviderFeignClientWithApi;

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerDemoWithApi.class, args);
    }

    @GetMapping("/hello02")
    public String hello02(String name) {
        String echo = demoProviderFeignClientWithApi.echo(name);
        // 返回结果
        return "consumer:" + echo;
    }
}
