package org.dullbird.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月21日 21:41:00
 */
public class LogApplication {
    private static AtomicInteger integer = new AtomicInteger(0);
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 30,
            30, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(), r ->
            new Thread(r, "test:" + integer.getAndIncrement()));

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String targetWord = "b";
        long startTime = System.currentTimeMillis();
        File file = new File("/Users/user01/workcontext/idea/learnSpace/dullbird-lab/question/question-log/src/main/resources/watch.log");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        List<Future<Long>> resultFuture = new ArrayList<>(16);
        List<String> temp = new ArrayList<>(10000);
        while ((line = reader.readLine()) != null) {
            temp.add(line);
            if (temp.size() % 9000 == 0) {
                resultFuture.add(
                        executor.submit(
                                new LogHandler(temp, targetWord)));
                temp = new ArrayList<>(10000);
            }
        }
        if (temp.size() > 0) {
            resultFuture.add(
                    executor.submit(
                            new LogHandler(temp, targetWord)));
            temp = null;
        }
        Long total = 0L;
        for (Future<Long> future : resultFuture) {
            total += future.get();
        }
        long durationTime = System.currentTimeMillis() - startTime;
        System.out.printf("error word[%s], count[%d], cost time [%d]\n", targetWord, total, durationTime);
        executor.shutdown();
    }
}

class LogHandler implements Callable<Long> {
    private List<String> logList;
    private String targetType;

    public LogHandler(List<String> logList, String targetType) {
        this.logList = logList;
        this.targetType = targetType;
    }

    @Override
    public Long call() {
        Long count = 0L;
        for (String log : logList) {
            String errorType = log.substring(0, log.indexOf(" "));
            if (Objects.equals(targetType, errorType)) {
                count++;
            }
        }
        return count;
    }
}
