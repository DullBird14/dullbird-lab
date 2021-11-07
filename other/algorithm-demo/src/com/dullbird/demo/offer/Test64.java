package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-31 21:53
 */
public class Test64 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
