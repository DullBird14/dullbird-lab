package org.dullbird.mybatis.plus.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月08日 23:30:00
 */
@SpringBootApplication
@MapperScan("org.dullbird.mybatis.plus.demo")
public class MybatisPlusApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplicationDemo.class, args);
    }
}
