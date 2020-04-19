package org.dullbird.cloud.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 20:26:00
 */
@SpringBootApplication
@EnableFeignClients
public class DubboFeignConsumerApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(DubboFeignConsumerApplicationDemo.class, args);
    }
}
