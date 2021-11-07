package com.dullbird.demo.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : cys
 * date: 2021-09-24 12:54
 */
public class Test91 {
    public static void main(String[] args) {
//        System.out.println("123".substring(2, 3));
        Test91 test91 = new Test91();
        System.out.println(test91.numDecodings("226"));
    }

    public int numDecodings(String s) {
        Set<String> validWords = new HashSet<>();
        init(validWords);
        int[] dp = new int[s.length() + 1];
        //取0位的时候有0种翻译
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            boolean mark = false;
            // 取一位的情况
            String code = s.substring(i - 1, i);
            if (validWords.contains(code)) {
                mark = true;
                dp[i] = dp[i] + dp[i-1];
            }
            //取2位的情况
            if (i - 2 >= 0) {
                code = s.substring(i - 2, i);
                if (validWords.contains(code)) {
                    mark = true;
                    dp[i] = dp[i] + dp[i-2];
                }
            }
            //剪枝
            if (!mark) {
                break;
            }
        }

        return dp[s.length()];
    }

    private void init(Set<String> validWords) {
        for (int i = 1; i <= 26; i++) {
            validWords.add(String.valueOf(i));
        }
    }
}
