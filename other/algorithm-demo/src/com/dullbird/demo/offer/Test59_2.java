package com.dullbird.demo.offer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-25 16:15
 */
public class Test59_2 {
    LinkedList<Integer> originQueue;
    LinkedList<Integer> maxQueue;

    public Test59_2() {
        originQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.getFirst();
    }

    public void push_back(int value) {
        originQueue.addLast(value);
        while (!maxQueue.isEmpty()
                && maxQueue.getLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (originQueue.isEmpty()) {
            return -1;
        }
        Integer integer = originQueue.removeFirst();
        if (Objects.equals(integer, maxQueue.peek())) {
            maxQueue.removeFirst();
        }
        return integer;
    }
}
