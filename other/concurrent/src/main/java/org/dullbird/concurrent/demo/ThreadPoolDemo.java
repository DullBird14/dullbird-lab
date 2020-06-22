package org.dullbird.concurrent.demo;

import java.util.concurrent.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月03日 09:48:00
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(30);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
//                30, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        // 测试max_thread_num
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                30, 30L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("===================== Thread start " + finalI
                            + " =====================");
                    Thread.sleep(10000L);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(10000L);
        while (!latch.await(2,
                TimeUnit.SECONDS)) {
            System.out.println(threadPoolExecutor.getPoolSize());
            System.out.println(threadPoolExecutor.getTaskCount());
            System.out.println(threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }
}
