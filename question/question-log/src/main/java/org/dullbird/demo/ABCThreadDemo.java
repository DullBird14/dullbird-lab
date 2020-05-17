package org.dullbird.demo;

import java.util.concurrent.Semaphore;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月22日 10:53:00
 */
public class ABCThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(1);
        Semaphore semaphoreC = new Semaphore(1);
        semaphoreA.acquire();
        semaphoreB.acquire();
        semaphoreC.acquire();
        new Thread(new TestThread(semaphoreA, semaphoreB, "A")).start();
        new Thread(new TestThread(semaphoreB, semaphoreC, "B")).start();
        new Thread(new TestThread(semaphoreC, semaphoreA, "C")).start();
        //有些同步逻辑需要等待其他线程完成启动之后，才行执行下面这句。但是当前这个不用
        semaphoreA.release(1);
        Thread.sleep(3000);
    }
}
class TestThread implements Runnable{
    private Semaphore semaphore;
    private Semaphore notifySemaphore;
    private String name;

    public TestThread(Semaphore semaphore, Semaphore notifySemaphore, String name) {
        this.semaphore = semaphore;
        this.notifySemaphore = notifySemaphore;
        this.name = name;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s线程打印。。。。第%d次\n", name, count);
            count --;
            notifySemaphore.release(1);
        }
    }
}
