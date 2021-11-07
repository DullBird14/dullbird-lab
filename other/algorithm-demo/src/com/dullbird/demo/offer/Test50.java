package com.dullbird.demo.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : cys
 * date: 2021-07-22 13:16
 */
public class Test50 {
    public static void main(String[] args) {
        Test50 test50 = new Test50();
        char abaccdeff = test50.firstUniqChar("abaccdeff");
    }
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, false);
            } else {
                map.put(aChar, true);
            }
        }
        for (Map.Entry<Character, Boolean> characterBooleanEntry : map.entrySet()) {
            if (characterBooleanEntry.getValue()) {
                return characterBooleanEntry.getKey();
            }
        }
        return ' ';
    }
}
