package com.dullbird.demo.leetCode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-18 23:32
 */
public class Test155 {
    public static void main(String[] args) {
        Test155 minStack = new Test155();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    LinkedList<Integer> originQueue;
    LinkedList<Integer> minQueue;

    public Test155() {
        originQueue = new LinkedList<>();
        minQueue = new LinkedList<>();
    }

    public void push(int val) {
        originQueue.addLast(val);
        if (minQueue.isEmpty()) {
            minQueue.addLast(val);
            return;
        }
        Integer integer = minQueue.peekLast();
        if (val <= integer) {
            minQueue.addLast(val);
        }
    }

    public void pop() {
        Integer integer = originQueue.pollLast();
        Integer minValue = minQueue.peekLast();
        if (Objects.equals(integer, minValue)) {
            minQueue.pollLast();
        }
    }

    public int top() {
        return originQueue.peekLast();
    }

    public int getMin() {
        return minQueue.peekLast();
    }
}
