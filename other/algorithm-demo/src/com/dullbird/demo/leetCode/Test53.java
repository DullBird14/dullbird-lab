package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-17 12:53
 */
public class Test53 {
    public static void main(String[] args) {
        Test53 test53 = new Test53();
        System.out.println(test53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(test53.maxSubArray(new int[]{-1}));
    }

    public int maxSubArray(int[] nums) {
        int tempSum = 0;
        int sum = Integer.MIN_VALUE;
        for (int num : nums) {
            int temp = tempSum + num;
            if (temp > 0) {
                tempSum = temp;
                if (tempSum > sum) {
                    sum=tempSum;
                }
            } else {
                tempSum = 0;
                if (num > sum) {
                    sum = num;
                }
            }
        }
        return sum;
    }
}
