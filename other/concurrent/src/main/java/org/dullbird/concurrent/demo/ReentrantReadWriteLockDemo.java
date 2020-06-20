package org.dullbird.concurrent.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月16日 19:47:00
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        CountDownLatch latch = new CountDownLatch(1);
        Thread thread = new Thread(() -> {
            lock.readLock()
                    .lock();
            latch.countDown();
            try {
                Thread.sleep(100000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        latch.await();
        lock.readLock()
                .lock();
    }
}
