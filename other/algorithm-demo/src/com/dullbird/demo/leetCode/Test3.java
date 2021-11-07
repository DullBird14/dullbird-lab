package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : cys
 * date: 2021-08-01 16:54
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int abcabcbb = test3.lengthOfLongestSubstring("abba");
        System.out.println(abcabcbb);
    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer index = map.get(chars[i]);
            map.put(chars[i], i);
            if (index == null) {
                sum ++;
            } else {
                left = Math.max(left, index);
                //更新最新的位置
                sum = i - left ;
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
