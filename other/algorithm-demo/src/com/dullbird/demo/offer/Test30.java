package com.dullbird.demo.offer;

import java.util.LinkedList;

/**
 * @author : cys
 * date: 2021-07-11 10:28
 */
public class Test30 {
    public static void main(String[] args) {

    }

    LinkedList<Integer> originStack ;
    LinkedList<Integer> unorderedMinStack ;

    /**
     * initialize your data structure here.
     */
    public Test30() {
        originStack = new LinkedList<>();
        unorderedMinStack = new LinkedList<>();
    }
    public void push(int x) {
        originStack.push(x);
        if (unorderedMinStack.isEmpty()
                || unorderedMinStack.peek() >= x) {
            unorderedMinStack.push(x);
        }
    }

    public void pop() {
        if (originStack.pop().equals(unorderedMinStack.peek())){
            unorderedMinStack.pop();
        }
    }

    public int top() {
        return originStack.peek();
    }

    public int min() {

        return unorderedMinStack.peek();
    }
}
