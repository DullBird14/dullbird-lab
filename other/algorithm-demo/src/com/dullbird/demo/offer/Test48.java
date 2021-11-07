package com.dullbird.demo.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : cys
 * date: 2021-07-25 00:21
 */
public class Test48 {
    public static void main(String[] args) {
        Test48 test48 = new Test48();
        int abcabcbb = test48.lengthOfLongestSubstring("");
        System.out.println(abcabcbb);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charAndIndexMap = new HashMap<>();
        int max = 0;
        int tempLength = 0;
        int movedIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            Integer index = charAndIndexMap.get(chars[i]);
            if (index != null
                    && movedIndex < index) {
                movedIndex = index;
                tempLength = i - index;
            } else {
                tempLength++;
            }
            if (tempLength > max) {
                max = tempLength;
            }
            charAndIndexMap.put(chars[i], i);
        }
        return max;
    }
}
