package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-08-22 21:58
 */
public class Test322 {
    public static void main(String[] args) {
        Test322 test322 = new Test322();
//        System.out.println(test322.coinChange(new int[]{5}, 10));
//        System.out.println(test322.coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(test322.coinChange(new int[]{2}, 3));
//        System.out.println(test322.coinChange(new int[]{1}, 0));
//        System.out.println(test322.coinChange(new int[]{1}, 1));
//        System.out.println(test322.coinChange(new int[]{1}, 2));
//        System.out.println(test322.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(test322.coinChange(new int[]{1,2147483647}, 2));
    }

    public int coinChange(int[] coins, int amount) {
        int[] records = new int[amount + 1];
        coins = Arrays.stream(coins).sorted().toArray();
        int min = Integer.MAX_VALUE;
        //从大到小遍历
        for (int i = coins.length - 1; i >= 0; i--) {
            int returnValue = inner(coins, records, 0, coins[i], amount);
            if (returnValue != -1) {
                min = Math.min(min, returnValue);
            }
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;
    }

    private int inner(int[] coins, int[] records, int current, int nextValue, int amount) {
        if (current == amount) {
            return records[current];
        }

        if (nextValue > amount - current) {
            return -1;
        }
        int record = records[current + nextValue];
        int currentAddNum = records[current] + 1;
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (record == 0) {
                //说明之前没有人到这个位置
                records[current + nextValue] = currentAddNum;
            } else {
                records[current + nextValue] = Math.min(currentAddNum, record);
            }
            if (record != 0
                    && currentAddNum >= record) {
                //说明之前有人处理过了。跳过
                continue;
            }
            int returnValue = inner(coins, records, current + nextValue, coins[i], amount);
            if (returnValue != -1) {
                min = Math.min(min, returnValue);
            }
        }
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;
    }
}
