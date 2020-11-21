package org.dullbird.concurrent;

import java.util.concurrent.*;

public class ThreadPoolExecuteAndSubmit {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testThreadPoolThrowException();
//        testThreadPoolReject();

    }

    private static void testThreadPoolReject() {
        ThreadPoolExecutor rejectExecutor = new ThreadPoolExecutor(1, 1, 60,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        rejectExecutor.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        try {
            rejectExecutor.submit(() -> {

            });
        } catch (Exception e) {
            System.out.println("=========>submit done:" + e);
        }

        rejectExecutor.execute(() -> {

        });
    }

    private static void testThreadPoolThrowException() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        boolean mark = true;
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (mark) {
                    throw new RuntimeException("execute exception!!!");
                }
            }
        });


        Future<?> future = executor.submit(new Runnable() {
            @Override
            public void run() {
                if (mark) {
                    throw new RuntimeException("submit exception!!!");
                }
            }
        });

        future.get();
    }
}
