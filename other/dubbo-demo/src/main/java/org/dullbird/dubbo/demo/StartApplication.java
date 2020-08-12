package org.dullbird.dubbo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月12日 15:46:00
 */
@SpringBootApplication
@ImportResource({"classpath:dubbo/consumer.xml","classpath:dubbo/provider.xml"})
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
