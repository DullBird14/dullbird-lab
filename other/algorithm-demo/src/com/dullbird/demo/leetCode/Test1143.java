package com.dullbird.demo.leetCode;

import java.util.*;

/**
 * @author : cys
 * date: 2021-11-02 13:01
 */
public class Test1143 {
    public static void main(String[] args) {
        Test1143 test1143 = new Test1143();
        System.out.println(test1143.longestCommonSubsequence("ashasm", "ahm"));
        System.out.println(test1143.longestCommonSubsequence("abc", "def"));
        System.out.println(test1143.longestCommonSubsequence("ylqpejqbalahwr", "yrkzavgdmdgtqpg"));
    }


    public int longestCommonSubsequence(String text1, String text2) {
        char[] oneChars = text1.toCharArray();
        char[] twoChars = text2.toCharArray();
        int M = oneChars.length;
        int N = twoChars.length;
        int[][] dp = new int[M+1][N+1];
        dp[0][0] = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (oneChars[i-1] == twoChars[j-1]) {
                    //最后一位相等
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i-1][j]);
                }
            }
        }
        return dp[M][N];
    }
}
