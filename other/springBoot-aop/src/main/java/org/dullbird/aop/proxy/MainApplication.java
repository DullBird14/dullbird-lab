package org.dullbird.aop.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author cys
 * @date 2018-09-21 下午7:06
 */
@SpringBootApplication
//@EnableTransactionManagement
public class MainApplication {
    public static void main(String args[]) {
        SpringApplication.run(MainApplication.class, args);
    }

}
