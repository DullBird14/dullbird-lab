package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;

/**
 * @author : cys
 * date: 2021-08-28 23:16
 */
public class Test76 {
    public static void main(String[] args) {
        Test76 test76 = new Test76();
        System.out.println(test76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(test76.minWindow("a", "aa"));
        System.out.println(test76.minWindow("aaa", "aa"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needCountMap = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char oneChar : chars) {
            Integer count = needCountMap.getOrDefault(oneChar, 0);
            needCountMap.put(oneChar, count + 1);
        }
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int currentCount = needCountMap.keySet().size();
        String result = "";
        do {
            if (currentCount > 0 ) {
                //移动j
                char c = s.charAt(j);
                Integer integer = needCountMap.get(c);
                if (integer != null) {
                    integer = integer - 1;
                    if (integer == 0) {
                        currentCount--;
                    }
                    needCountMap.put(c, integer);
                }
                j++;
            } else {
                //移动i;
                char c = s.charAt(i);
                Integer integer = needCountMap.get(c);
                if (integer != null) {
                    integer = integer + 1;
                    if (integer > 0) {
                        currentCount = currentCount + 1;
                    }
                    needCountMap.put(c, integer);
                }
                i++;
            }
            if (currentCount == 0 && j - i < min) {
                min = j - i + 1;
                result = s.substring(i, j);
            }

        } while (j < s.length()
                || currentCount==0);
        return result;
    }
}
