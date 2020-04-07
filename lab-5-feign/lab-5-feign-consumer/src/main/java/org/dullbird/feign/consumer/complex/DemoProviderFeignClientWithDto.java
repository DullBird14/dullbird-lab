package org.dullbird.feign.consumer.complex;

import org.dullbird.feign.api.TestService;
import org.dullbird.feign.api.dto.DemoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 21:29:00
 */
@FeignClient(name = "demo-provider")
public interface DemoProviderFeignClientWithDto extends TestService {
    // GET 方式一，最推荐
    @GetMapping("/get_demo")
    DemoDTO getDemo(@SpringQueryMap DemoDTO demoDTO);
    // GET 方式二，相对推荐
    @GetMapping("/get_demo")
    DemoDTO getDemo(@RequestParam("username") String username, @RequestParam("password") String password);

    // GET 方式三，不推荐
    @GetMapping("/get_demo")
    DemoDTO getDemo(@RequestParam Map<String, Object> params);

    // POST 方式
    @PostMapping("/post_demo")
    DemoDTO postDemo(@RequestBody DemoDTO demoDTO);
}
