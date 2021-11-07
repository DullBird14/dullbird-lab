package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-25 16:58
 */
public class Test63 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = Integer.MAX_VALUE;
        int tempValue = 0;
        for (int price : prices) {
            tempValue = price - start + tempValue;
            if (tempValue < 0) {
                tempValue = 0;
            } else if (tempValue > max) {
                max = tempValue;
            }
            start = price;
        }
        return max;
    }
}
