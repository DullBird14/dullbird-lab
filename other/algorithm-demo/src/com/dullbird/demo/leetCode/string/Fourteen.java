package com.dullbird.demo.leetCode.string;


/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月06日 23:40:00
 */
public class Fourteen {
    public static void main(String[] args) {
        Fourteen fourteen = new Fourteen();
//        String s = fourteen.longestCommonPrefix(new String[]{"aa", "a"});
        String s = fourteen.longestCommonPrefix(new String[]{"aa", "abc", "att"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null && strs.length == 0) {
            return "";
        }
        int index = strs[0].length();
        int commonIndex = 0;
        for (int j = 0; j < index; j++) {
            char commonChar = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= j
                        || strs[i].charAt(j) != commonChar) {
                    //直接用 return 代替
                    return strs[0].substring(0, commonIndex);
                }
            }
            commonIndex++;
        }

        return strs[0].substring(0, commonIndex);
    }
}
