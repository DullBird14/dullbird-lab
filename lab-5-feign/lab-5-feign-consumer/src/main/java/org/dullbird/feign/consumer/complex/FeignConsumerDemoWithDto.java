package org.dullbird.feign.consumer.complex;

import org.dullbird.feign.api.dto.DemoDTO;
import org.dullbird.feign.consumer.api.DemoProviderFeignClientWithApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 17:41:00
 */
@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignConsumerDemoWithDto {

    @Autowired
    private DemoProviderFeignClientWithDto demoProviderFeignClientWithDto;

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerDemoWithDto.class, args);
    }

    @GetMapping("/test_get_demo")
    public String hello01(@RequestParam String username, @RequestParam String password, @RequestParam Integer type) {
        DemoDTO demo =null;
        if (Objects.equals(type, 1)) {
            demo = demoProviderFeignClientWithDto.getDemo(username, password);
        } else if (Objects.equals(type, 2)) {
            DemoDTO demoDTO = new DemoDTO();
            demoDTO.setUsername(username);
            demoDTO.setPassword(password);
            demo = demoProviderFeignClientWithDto.getDemo(demoDTO);
        } else if (Objects.equals(type, 3)) {
            Map<String, Object> map = new HashMap<>();
            map.put("username", username);
            map.put("password", password);
            demo = demoProviderFeignClientWithDto.getDemo(map);
        }
        return "consumer:" + demo;
    }

    @GetMapping("/test_post_demo")
    public String hello02(@RequestParam String username, @RequestParam String password, @RequestParam Integer type) {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setUsername(username);
        demoDTO.setPassword(password);
        DemoDTO demoDTO1 = demoProviderFeignClientWithDto.postDemo(demoDTO);
        return "consumer:" + demoDTO1;
    }
}
