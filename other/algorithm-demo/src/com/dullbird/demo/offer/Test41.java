package com.dullbird.demo.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : cys
 * date: 2021-07-31 13:49
 */
public class Test41 {


    public static void main(String[] args) {
//        PriorityQueue<Double> ts = new PriorityQueue<>(Comparator.reverseOrder());
//        ts.add(1.0);
//        ts.add(2.0);
//        ts.add(3.0);
//        System.out.println(ts.poll());
//        System.out.println(ts.poll());
//        System.out.println(ts.poll());
        Test41 test41 = new Test41();
        test41.addNum(1);
        System.out.println(test41.findMedian());
        test41.addNum(2);
        System.out.println(test41.findMedian());
        test41.addNum(3);
        System.out.println(test41.findMedian());
        test41.addNum(4);
        System.out.println(test41.findMedian());

    }

    //小顶堆
    private PriorityQueue<Integer> minStock;
    //大顶堆
    private PriorityQueue<Integer> maxStock;

    public Test41() {
        minStock = new PriorityQueue<>(Comparator.naturalOrder());
        maxStock = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (maxStock.isEmpty()) {
            maxStock.add(num);
            return;
        }
        Integer maxNumInHalf = maxStock.peek();
        if (maxNumInHalf >= num) {
            maxStock.add(num);
        } else {
            minStock.add(num);
        }
        if (maxStock.size() > minStock.size()) {
            minStock.add(maxStock.poll());
        } else if (maxStock.size() < minStock.size()){
            maxStock.add(minStock.poll());
        }

    }

    public double findMedian() {
        if (minStock.size() > maxStock.size()) {
            return Double.valueOf(minStock.peek());
        } else if (maxStock.size() > minStock.size()) {
            return Double.valueOf(maxStock.peek());
        }
        return (minStock.peek() + maxStock.peek()) / 2.0;
    }
}
