package org.dullbird.concurrent.demo;

import java.util.concurrent.*;

/**
 * 验证 pool 的 submit 是否不会报错
 * 1. submit 的任务会被包装成 FutureTask，其中会把异常捕获
 * 2. execute 不会包装
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月07日 13:40:00
 */
public class ThreadPoolSubmitDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2,
                0, TimeUnit.SECONDS, new SynchronousQueue<>());
        CountDownLatch latch = new CountDownLatch(1);
        // submit
        Future<?> taskProcess = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task process");
                try {
                    throw new RuntimeException();
                } finally {
                    latch.countDown();
                }
            }
        });
        latch.await();
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }
}
