package com.dullbird.demo.leetCode;

import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-30 13:17
 */
public class Test05 {
    //todo
    public static void main(String[] args) {
        Test05 test05 = new Test05();
        System.out.println(test05.longestPalindrome("ccc"));
    }

    private int min = 0;
    private int max = 0;

    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return new String(chars);
        }
        int maxLength = 0;
        String result = s.substring(0, 1);
        for (int i = 0; i < chars.length - 1; ) {
            if (chars[i] == chars[i + 1]) {
                checkIsOk(chars, i, i + 1);
            } else if (i - 1 > 0
                    && chars[i - 1] == chars[i + 1]) {
                checkIsOk(chars, i - 1, i + 1);
            } else {
                i++;
                continue;
            }
            if (max - min > maxLength) {
                maxLength = max - min;
                result = s.substring(min, max + 1);
                i = max + 1;
            }
        }
        return result;
    }

    private void checkIsOk(char[] chars, int i, int j) {
        if (i < 0 || j >= chars.length) {
            return;
        }
        if (chars[i] != chars[j]) {
            return;
        }
        if (chars[i] == chars[j]) {
            min = i;
            max = j;
            checkIsOk(chars, i - 1, j + 1);
        }
    }

}
