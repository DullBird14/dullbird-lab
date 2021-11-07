package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-11-03 13:20
 */
public class Test718 {
    public static void main(String[] args) {
        Test718 test718 = new Test718();
        System.out.println(test718.findLength(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}
                ));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int maxCount = 0;
        //暴力法
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                int currentCount = 0;
//                int tempX = i;
//                int tempY = j;
//                while (tempX < nums1.length
//                        && tempY < nums2.length
//                        && nums2[tempX++] == nums1[tempY++]) {
//                    currentCount++;
//                }
//                if (currentCount > maxCount) {
//                    maxCount = currentCount;
//                }
//            }
//        }
        //动态规划
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (dp[i][j] > maxCount) {
                    maxCount = dp[i][j];
                }
            }
        }
        return maxCount;
    }
}
