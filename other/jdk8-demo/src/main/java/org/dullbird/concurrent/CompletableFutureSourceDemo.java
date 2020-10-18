package org.dullbird.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureSourceDemo {
    public static void main(String[] args) {
//        testOne();
//        testTwo();
        testThree();

    }

    private static void testThree() {

        CompletableFuture one = CompletableFuture.supplyAsync(() -> {
            try {
                //休眠200秒
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync " + Thread.currentThread().getName());
            return "hello ";
        });
//        CompletableFuture one_two = one.thenAccept((s) -> {
//            System.out.println("one.result:" + s);
//            System.out.println("one_two");
//        });
        CompletableFuture two = CompletableFuture.supplyAsync(() -> {
            System.out.println("two start....");
            boolean mark = true;
            if (mark) {
                throw new RuntimeException("exception!!!!");
            }
            return "hell two";
        });
//                .exceptionally((e) -> {
//                    System.out.println("two exception " + e);
//
//                    return "two exception recover!";
//                });

        CompletableFuture.allOf(one, two).join();
//        CompletableFuture two_two = two.thenAccept((s) -> {
//            System.out.println("two.result:" + s);
//            System.out.println("two_two");
//        });

    }

    private static void testOne() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            try {
                //休眠200秒
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync " + Thread.currentThread().getName());
            return "hello ";
        }, executorService);

        System.out.println(Thread.currentThread().getName());
        while (true) {
            if (cf.isDone()) {
                System.out.println("CompletedFuture...isDown");
                break;
            }
        }
    }

    private static void testTwo() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            try {
                //休眠200秒
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync " + Thread.currentThread().getName());
            return "hello ";
        }, executorService)
                .thenAccept(s -> {
                    try {
                        thenApply_test(s + "world");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        System.out.println(Thread.currentThread().getName());
        while (true) {
            if (cf.isDone()) {
                System.out.println("CompletedFuture...isDown");
                break;
            }
        }
    }


    private static void thenApply_test(String s) {
        System.out.println(s);
    }
}
