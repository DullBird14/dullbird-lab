package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-08 00:23
 */
public class Test121 {
    public static void main(String[] args) {
        Test121 test121 = new Test121();
        int i = test121.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int max = 0;
        int toDay = 0;
        int start = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            toDay = Math.max(0, prices[i] - start + toDay);
            if (toDay > max) {
                max = toDay;
            }
            start = prices[i];
        }
        return max;
    }
}
