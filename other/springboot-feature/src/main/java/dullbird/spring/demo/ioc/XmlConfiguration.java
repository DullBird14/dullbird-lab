package dullbird.spring.demo.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : cys
 * date: 2021-05-09 20:44
 */
@Configuration
@ImportResource({"classpath:test-bean.xml"})
public class XmlConfiguration {
    @Bean
    public String test() {
        return "abc";
    }
}