package com.dullbird.demo.offer;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : cys
 * date: 2021-07-31 17:27
 */
public class Test45 {
    public static void main(String[] args) {
        System.out.println("30".compareTo("3"));
    }

    public String minNumber(int[] nums) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1, o2)) {
                return 0;
            }
            return (o1+o2).compareTo(o2+o1);
        });
        for (int num : nums) {
            priorityQueue.add(String.valueOf(num));
        }
        StringBuilder builder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            builder.append(priorityQueue.poll());
        }
        return builder.toString();
    }
}
