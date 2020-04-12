package org.dullbird.sentinel.consumer;

import org.dullbird.sentinel.consumer.feign.DemoFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月12日 11:12:00
 */
@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/consumer")
public class SentinelConsumerApplicationDemo {

    @Resource
    private DemoFeignClient demoFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(SentinelConsumerApplicationDemo.class, args);
    }


    @GetMapping("/echo")
    public String test() {
        String echo = demoFeignClient.echo();
        return echo;
    }

    @GetMapping("/annotations_demo")
    public String test(@RequestParam Integer id) {
        return demoFeignClient.annotationsDemo(id);
    }

}
