package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-29 13:01
 */
public class Test05 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
