package org.dullbird.fegin.provider.api;

import org.dullbird.fegin.provider.normal.FeignProviderDemo;
import org.dullbird.feign.api.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 17:37:00
 */
@SpringBootApplication
public class FeignProviderWithApiDemo {
    public static void main(String[] args) {
        SpringApplication.run(FeignProviderWithApiDemo.class, args);
    }

    @RestController
    static class TestController implements TestService {

        private Logger logger = LoggerFactory.getLogger(TestController.class);

        @Value("${server.port}")
        private Integer serverPort;


        @Override
        public String echo(String name) {
            // 模拟执行 100ms 时长。方便后续我们测试请求超时
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 记录被调用的日志
            logger.info("[echo][被调用啦 name({})]", name);

            return serverPort + "-provider:" + name;
        }
    }

}
