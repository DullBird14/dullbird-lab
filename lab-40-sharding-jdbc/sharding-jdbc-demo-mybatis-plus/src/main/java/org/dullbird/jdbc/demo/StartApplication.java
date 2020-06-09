package org.dullbird.jdbc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月07日 23:45:00
 */
@SpringBootApplication
@MapperScan(basePackages = "org.dullbird.jdbc.demo.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
    }

}
