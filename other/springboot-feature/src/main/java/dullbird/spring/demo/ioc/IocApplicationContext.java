package dullbird.spring.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author : cys
 * date: 2021-05-09 20:19
 */
@SpringBootApplication
public class IocApplicationContext implements CommandLineRunner {
    @Autowired
    private RealBean realBean;

    public static void main(String[] args) {
        SpringApplication.run(IocApplicationContext.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==================>" + realBean.getVersion() + "<==================");
    }
}