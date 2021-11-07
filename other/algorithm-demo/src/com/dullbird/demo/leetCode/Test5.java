package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-04 20:15
 */
public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        System.out.println(test5.longestPalindrome("babbad"));
        System.out.println(test5.longestPalindrome("babad"));
        System.out.println(test5.longestPalindrome("cbbd"));
        System.out.println(test5.longestPalindrome("a"));
        System.out.println(test5.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        //右边界
        for (int j = 1; j < chars.length; j++) {
            for (int i = 0; i < j; i++) {
                if (j - i <3) {
                    boolean b = chars[i] == chars[j];
                    dp[i][j] = b;
                } else {
                    if (dp[i + 1][j - 1]
                            && chars[i] == chars[j]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
