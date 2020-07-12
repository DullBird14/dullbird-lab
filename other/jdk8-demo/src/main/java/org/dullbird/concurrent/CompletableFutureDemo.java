package org.dullbird.concurrent;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月11日 22:48:00
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {

        // 正常的测试
//        normalFutureTest();
        // 串行的测试
//        serialFutureTest();
        // 并行测试
//        parallelFutureTest();

        // 包含一些参数的测试
        normalFutureWithOtherParamTest();
        LockSupport.park();
    }

    /**
     * 测试一些额外功能
     * 1. 1.8的api中无法设置超时执行，1.9之后有
     * 2. cancel 无法停止已经启动的线程，
     */
    private static void normalFutureWithOtherParamTest() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after sleep 5000ms");
            return "result";
        });
        //设置一个不等待的任务
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("after no sleep ");
            throw new IllegalStateException("no result");
//            return "no result";
        });
        // 任意一个执行完了，就执行结果的操作。
        future.acceptEither(completableFuture, s -> {
            System.out.println(s);
        }).exceptionally(e -> {
            e.printStackTrace();
            //这个两个取消并不会影响线程，线程依然继续执行。
            future.cancel(false);
            completableFuture.cancel(false);
            return null;
        });
    }

    /**
     * 同时执行C和D，任意返回就根据结果执行E和F
     */
    private static  Random random = new Random();

    private static void parallelFutureTest() {
        // 任务C和D
        CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(getStringSupplier("result C"));
        CompletableFuture<String> dFuture = CompletableFuture.supplyAsync(getStringSupplier("result D"));
        cFuture.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        dFuture.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        // 合成任务C和D。任意一个返回
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(cFuture, dFuture);
        CompletableFuture<Integer> efuture = anyOf.thenApplyAsync(getFunction(50));
        CompletableFuture<Integer> ffuture = anyOf.thenApplyAsync(getFunction(100));
        efuture.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        ffuture.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
        CompletableFuture<Object> resultFuture = CompletableFuture.anyOf(efuture, ffuture);
        resultFuture.thenAccept(e->{
            System.out.println("result================" + e);
        });
    }
    private static Function<Object, Integer> getFunction(Integer result) {
        return (input) -> {
            System.out.println("input:value:=====" + result);
            try {
                Thread.sleep(getRandomLong());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        };
    }

    private static Supplier<String> getStringSupplier(String result) {
        return () -> {
            System.out.println("start task=====================" + result);
            try {
                Thread.sleep(getRandomLong());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        };
    }
    private static long getRandomLong(){
        long min = 1;
        long max = 5000;
        long rangeLong = min + (((long) (random.nextDouble() * (max - min))));
        return rangeLong;
    }
    /**
     * 先执行 doSomethingA 方法,拿到返回值
     * 做为 doSomethingB 方法的入参
     */
    private static void serialFutureTest() {
        //任务A
        CompletableFuture<String> aFuture = CompletableFuture.supplyAsync(CompletableFutureDemo::doSomethingA);
        // 拿任务A的结果，作为任务B的入参
        CompletableFuture<Integer> bFuture = aFuture.thenApplyAsync(CompletableFutureDemo::doSomethingB);
        bFuture.thenAccept((e)-> System.out.println("final result " + e));

    }

    static String doSomethingA(){
        System.out.println("doSomethingA:============");
        return "aaa";

    }
    static Integer doSomethingB(String input){
        System.out.println("doSomethingB:============" + input);
        return 100;
    }

    private static void normalFutureTest() {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);
        //等待

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("================wait over=================");

        cf.thenAccept((aDouble -> {
            System.out.println(aDouble);
        }));
        cf.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        System.out.println("================100=================");
        return 5 + Math.random() * 20;
    }
}
