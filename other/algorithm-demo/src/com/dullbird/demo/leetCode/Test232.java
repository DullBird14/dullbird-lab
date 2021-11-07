package com.dullbird.demo.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : cys
 * date: 2021-08-28 16:20
 */
public class Test232 {
    public static void main(String[] args) {
        Test232 myQueue = new Test232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    private LinkedList<Integer> originQueue;
    private LinkedList<Integer> showQueue;

    /**
     * Initialize your data structure here.
     */
    public Test232() {
        originQueue = new LinkedList<>();
        showQueue = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        originQueue.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (showQueue.isEmpty()) {
            init();
        }
        return showQueue.pollLast();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (showQueue.isEmpty()) {
            init();
        }
        return showQueue.peekLast();
    }

    private void init() {
        while (originQueue.size() > 0) {
            showQueue.addLast(originQueue.pollLast());
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

        return originQueue.size() == 0
                && showQueue.size() == 0;
    }
}
