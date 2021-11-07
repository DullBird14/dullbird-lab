package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-28 00:01
 */
public class Test122 {
    public static void main(String[] args) {
        Test122 test122 = new Test122();
        System.out.println(test122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(test122.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test122.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int beforeDay = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            int value = price - beforeDay;
            if (value > 0) {
                max += value;
            }
            beforeDay = price;
        }
        return max;
    }
}
