package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-09-17 22:13
 */
public class Test188 {
    public static void main(String[] args) {
        Test188 test188 = new Test188();
//        System.out.println(test188.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(test188.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices ==null
                || prices.length == 0) {
            return 0;
        }
        //1。第i天的情况 2.持有股票还是不持有股票 3.交易次数,卖一次算一次
        int[][][] dp = new int[prices.length][k + 1][2];
        k = Math.min(k, prices.length / 2);
        // 0 代表没有持有，1表示持有股票。
        for (int i1 = 1; i1 <= k; i1++) {
            dp[0][i1][0] = 0;
            dp[0][i1][1] = -prices[0];
        }
//        printArrays(dp);
        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                // 1.要么之前没有持有。继续不持有。    2.要么把手头的股票都卖了
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 2.之前没有。现在买了
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);

            }
        }
//        printArrays(dp);
        return dp[prices.length - 1][k][0];
    }

//    private void printArrays(int[][][] dp) {
//        int i = dp.length;
//        int j = dp[0].length;
//        for (int i1 = 0; i1 < i; i1++) {
//            for (int i2 = 0; i2 < j; i2++) {
//                System.out.printf("%s\t", dp[i1][i2][0]);
//            }
//            System.out.println();
//        }
//        System.out.println("============不持有================");
//        for (int i1 = 0; i1 < i; i1++) {
//            for (int i2 = 0; i2 < j; i2++) {
//                System.out.printf("%s\t", dp[i1][i2][1]);
//            }
//            System.out.println();
//        }
//        System.out.println("=============持有================");
//    }
}
