package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-28 21:40
 */
public class Test198 {
    public static void main(String[] args) {
        Test198 test198 = new Test198();
        System.out.println(test198.rob(new int[]{1, 2, 3, 1}));
        System.out.println(test198.rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int valueOne = i - 3 >= 0 ? dp[i - 3] : 0;
            int valueTwo = i - 2 >= 0 ? dp[i - 2] : 0;
            dp[i] = Math.max(valueOne + nums[i], valueTwo + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
