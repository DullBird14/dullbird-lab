package com.dullbird.demo.leetCode;

import java.util.LinkedList;

/**
 * @author : cys
 * date: 2021-09-25 17:47
 */
public class Test862 {
    public static void main(String[] args) {
        Test862 test862 = new Test862();
//        System.out.println(test862.shortestSubarray(new int[]{1, 2}, 4));
//        System.out.println(test862.shortestSubarray(new int[]{1}, 1));
//        System.out.println(test862.shortestSubarray(new int[]{2, -1, 2}, 3));
//        System.out.println(test862.shortestSubarray(new int[]{-1, 1, -1, 1, 0}, 0));
        System.out.println(test862.shortestSubarray(new int[]{-1, 2, 1}, 1));
    }

    public int shortestSubarray(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }

//        int minLength = Integer.MAX_VALUE;
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = i; j >= 0; j--) {
//                if (dp[i] - dp[j] >= k) {
//                    minLength = Math.min(i - j, minLength);
//                }
//            }
//        }
//        return minLength == Integer.MAX_VALUE ? -1 : minLength;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            while (!linkedList.isEmpty()
                    && dp[i] <= dp[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            while (!linkedList.isEmpty()
                    && dp[i] >= dp[linkedList.getFirst()] + k) {
                minLength = Math.min(minLength, i - linkedList.removeFirst());
            }
            linkedList.addLast(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
