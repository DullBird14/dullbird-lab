package com.dullbird.demo.offer;


/**
 * @author : cys
 * date: 2021-07-27 12:56
 */
public class Test58_2 {
    public static void main(String[] args) {
        Test58_2 test58_2 = new Test58_2();

        String abcdef = test58_2.reverseLeftWords("abcdef", 2);
        assert abcdef.equals("cdefab");
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            result.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
