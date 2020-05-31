package org.dullbird.spring.user.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月28日 23:48:00
 */
@SpringBootApplication
//@EnableDiscoveryClient
public class UserServiceStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceStartApplication.class, args);
    }
}
