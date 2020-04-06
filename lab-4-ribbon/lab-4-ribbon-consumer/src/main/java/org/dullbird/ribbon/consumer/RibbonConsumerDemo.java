package org.dullbird.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 14:58:00
 */
@SpringBootApplication
public class RibbonConsumerDemo {
    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerDemo.class, args);
    }
    @Configuration
    public class RestTemplateConfiguration {
        @Bean
        @LoadBalanced
        public RestTemplate restTemplateWithBalance(){
            return new RestTemplate();
        }

        @Bean
        public RestTemplate restTemplateWithoutBalance(){
            return new RestTemplate();
        }
    }
    @RestController
    public class RestDemoController {
        @Autowired
        @Qualifier("restTemplateWithoutBalance")
        private RestTemplate restTemplateWithoutBalance;

        @Autowired
        @Qualifier("restTemplateWithBalance")
        private RestTemplate restTemplateWithBalance;

        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @GetMapping("/hello")
        public String hello(String name) {
            //根据服务名称选择服务实例
            ServiceInstance instance = loadBalancerClient.choose("demo-provider");
            // 构建url，并且调用
            String targetUrl = instance.getUri() + "/echo?name=" + name;
            String response = restTemplateWithoutBalance.getForObject(targetUrl, String.class);
            return "consumer:" + response;
        }

        @GetMapping("/hello02")
        public String hello02(String name) {
            // 直接使用 RestTemplate 调用服务 `demo-provider`
            String targetUrl = "http://demo-provider/echo?name=" + name;
            String response = restTemplateWithBalance.getForObject(targetUrl, String.class);
            // 返回结果
            return "consumer:" + response;
        }
    }

}
