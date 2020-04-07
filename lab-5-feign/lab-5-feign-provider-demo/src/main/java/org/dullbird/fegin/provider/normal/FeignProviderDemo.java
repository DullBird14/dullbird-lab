package org.dullbird.fegin.provider.normal;

import org.dullbird.fegin.provider.api.FeignProviderWithApiDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 17:37:00
 */
@SpringBootApplication
public class FeignProviderDemo {
    public static void main(String[] args) {
        SpringApplication.run(FeignProviderDemo.class, args);
    }

    @RestController
    static class TestController {

        private Logger logger = LoggerFactory.getLogger(TestController.class);

        @Value("${server.port}")
        private Integer serverPort;

        @GetMapping("/echo")
        public String echo(String name) throws InterruptedException {
            // 模拟执行 100ms 时长。方便后续我们测试请求超时
            Thread.sleep(100L);

            // 记录被调用的日志
            logger.info("[echo][被调用啦 name({})]", name);

            return serverPort + "-provider:" + name;
        }

    }

}
