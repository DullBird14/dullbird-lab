package org.dullbird.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        executor.execute(() -> {
            System.out.println("start task");
            try {
                Thread.sleep(30000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end task");
        });
        executor.submit(() -> {
            System.out.println("start task");
            try {
                Thread.sleep(30000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end task");
        });
        executor.shutdown();
        executor.execute(() -> {
            System.out.println("start task after shutdown");
        });
        executor.shutdownNow();

//        System.out.println("after shutdown");
//
//        executor.submit(() -> {
//            System.out.println("task two!!!");
//        });
        System.out.println(Integer.toBinaryString(29));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(Integer.toBinaryString(1 << 29));
        System.out.println(Integer.toBinaryString(0 << 29));

    }
}
