package org.dullbird.sentinel.consumer.fallback;

import org.dullbird.sentinel.consumer.feign.DemoFeignClient;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月12日 16:18:00
 */
public class DemoProviderFeignClientFallback implements DemoFeignClient {

    private Throwable throwable;

    public DemoProviderFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo() {
        return "fallback echo:" + throwable.getClass().getSimpleName();
    }

    @Override
    public String annotationsDemo(Integer id) {
        return "fallback annotationsDemo:" + throwable.getClass().getSimpleName();
    }

}
