package dullbird.spring.demo.retry;


import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.BackOffContext;
import org.springframework.retry.backoff.BackOffInterruptedException;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryDemo {
    public static void main(String[] args) throws Throwable {
        RetryTemplate template = RetryTemplate.builder()
                .maxAttempts(10)
                .uniformRandomBackoff(1000, 3000)
//                .fixedBackoff(1000)
                .retryOn(Exception.class)
                .build();
        AtomicInteger retryNum = new AtomicInteger();
        template.execute(ctx -> {
            System.out.println("111111");
            return null;
        });
        template.execute(new RetryCallback<Object, Throwable>() {
            @Override
            public Object doWithRetry(RetryContext context) throws Throwable {
                System.out.println("执行重试======" + retryNum.getAndIncrement());
                throw new IllegalStateException("temp");
            }
        }, new RecoveryCallback<Object>() {
            @Override
            public Object recover(RetryContext context) throws Exception {
                System.out.println("执行recover======" );

                return null;
            }
        });

    }
}
