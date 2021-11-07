package com.dullbird.demo.offer;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-27 12:52
 */
public class Test58_1 {
    public static void main(String[] args) {
        Test58_1 test58_1 = new Test58_1();
        String theSkyIsBlue = test58_1.reverseWords("the sky is blue");
        System.out.println(theSkyIsBlue);
    }
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            builder.append(split[i] + " ");
        }
        return builder.toString().trim();
    }
}
