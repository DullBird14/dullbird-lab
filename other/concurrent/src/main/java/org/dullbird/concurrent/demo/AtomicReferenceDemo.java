package org.dullbird.concurrent.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月03日 11:01:00
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<User> userAtomicReference = new AtomicReference<User>();
        User old = new User(3L, "haha");
        userAtomicReference.set(old);
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(()->{
            userAtomicReference.set(null);
            latch.countDown();
        }).start();
        latch.await();
        User update = new User(1L, "xixi");
        userAtomicReference.compareAndSet(old, update);
        System.out.println(old);
        System.out.println(update);
        System.out.println(userAtomicReference.get());

    }
}

