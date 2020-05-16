package org.dullbird.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月13日 12:42:00
 */
@SpringBootApplication
@NacosPropertySource(dataId = "", groupId = "task", autoRefreshed = true)
public class ProfilesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProfilesApplication.class, args);
    }

}
