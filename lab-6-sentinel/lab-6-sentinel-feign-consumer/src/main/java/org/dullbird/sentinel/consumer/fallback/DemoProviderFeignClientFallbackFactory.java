package org.dullbird.sentinel.consumer.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月12日 16:17:00
 */
@Component
public class DemoProviderFeignClientFallbackFactory implements FallbackFactory<DemoProviderFeignClientFallback> {
    @Override
    public DemoProviderFeignClientFallback create(Throwable cause) {
        return new DemoProviderFeignClientFallback(cause);
    }
}
