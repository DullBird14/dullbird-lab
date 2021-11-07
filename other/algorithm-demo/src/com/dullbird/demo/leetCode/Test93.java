package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-09-06 13:17
 */
public class Test93 {
    public static void main(String[] args) {
        Test93 test93 = new Test93();
        System.out.println(test93.restoreIpAddresses("25525511135"));
    }

    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        for (int i = 0; i <= s.length(); i++) {
            innerRestoreIpAddresses(s, s.substring(0, i + 1), i+1, "");
        }
        return result;
    }

    private void innerRestoreIpAddresses(String s, String currentValue,
                                         int i, String temp) {

        if (!temp.equals("")
                && Integer.parseInt(currentValue) < 0
                && Integer.parseInt(currentValue) > 255) {
            return;
        }
//        if (Integer.parseInt(currentValue) >= 0
//                && Integer.parseInt(currentValue) <= 255) {
//            temp = temp + currentValue + ".";
//            i =
//        }
        if (s.length() == i) {
            result.add(temp + currentValue );
            return;
        }

        for (int j = i; j < s.length(); j++) {
            innerRestoreIpAddresses(s, s.substring(i, j+1), j+1, temp + currentValue);
        }

    }
}
