package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-13 22:44
 */
public class Test209 {
    public static void main(String[] args) {
        Test209 test209 = new Test209();
        System.out.println(test209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(test209.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(test209.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int minCount = Integer.MAX_VALUE;
        int tempCount = 0;
        int tempSum = 0;
        while (j < nums.length
                || tempSum > target) {
            if (tempSum < target) {
                tempSum += nums[j++];
                tempCount++;
                if (tempSum >= target) {
                    minCount = Math.min(tempCount, minCount);
                }
            } else {
                tempSum -= nums[i++];
                tempCount--;
                if (tempSum >= target) {
                    minCount = Math.min(tempCount, minCount);
                }
            }
        }
        if (minCount == Integer.MAX_VALUE) {
            return 0;
        }
        return minCount;
    }
}
