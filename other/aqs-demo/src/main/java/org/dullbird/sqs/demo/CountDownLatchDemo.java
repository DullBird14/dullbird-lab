package org.dullbird.sqs.demo;


import java.util.concurrent.CountDownLatch;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月16日 20:33:00
 */
public class CountDownLatchDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);
    private static CountDownLatch boss = new CountDownLatch(5);

    /**
     * Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有人都已经到齐了，开会吧...");
        }
    }

    //员工到达会议室
    static class EmpleoyeeThread extends Thread {
        private int timeCount;

        public EmpleoyeeThread(int timeCount) {
            this.timeCount = timeCount;
        }

        @Override
        public void run() {
            try {
                //间隔开来
                Thread.sleep(timeCount * 30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
            //员工到达会议室 count - 1
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        BossThread bossThread = new BossThread();
        bossThread.setName("boss-thread");
        bossThread.start();
        long count = countDownLatch.getCount();
        for (int i = 0; i < count; i++) {
            EmpleoyeeThread empleoyeeThread = new EmpleoyeeThread(i);
            empleoyeeThread.setName("worker-thread" + i);
            empleoyeeThread.start();
        }
    }
}
