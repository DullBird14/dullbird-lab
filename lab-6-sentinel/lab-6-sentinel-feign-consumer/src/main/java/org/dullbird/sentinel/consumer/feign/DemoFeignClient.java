package org.dullbird.sentinel.consumer.feign;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.dullbird.sentinel.consumer.fallback.DemoProviderFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月12日 11:10:00
 */
//因为没有接入nacos，所以直接填写了ip
@FeignClient(name = "demo-provider", url = "http://127.0.0.1:8080",
        fallbackFactory = DemoProviderFeignClientFallbackFactory.class)
public interface DemoFeignClient {


    @GetMapping("/demo/echo")
    String echo();

    @GetMapping("/demo/annotations_demo")
    String annotationsDemo(@RequestParam(required = false) Integer id);
}
