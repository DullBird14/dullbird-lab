package org.dullbird.concurrent.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于替换 wait 和 notify
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 10:41:00
 */
public class ConditionDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger integer = new AtomicInteger(0);

        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " get lock");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " deal "
                            + integer.getAndIncrement());
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " get lock");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " deal "
                            + integer.getAndIncrement());
                    condition.signal();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "B").start();
    }
}
