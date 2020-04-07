package org.dullbird.feign.consumer.api;

import org.dullbird.feign.api.TestService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 21:29:00
 */
@FeignClient(name = "demo-provider")
public interface DemoProviderFeignClientWithApi extends TestService {

}
