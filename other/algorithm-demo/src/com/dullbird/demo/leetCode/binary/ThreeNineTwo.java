package com.dullbird.demo.leetCode.binary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cys
 * @date 2019-11-13 12:43
 */

public class ThreeNineTwo {
    public static void main(String[] args) {
        ThreeNineTwo threeNineTwo = new ThreeNineTwo();
        System.out.println(threeNineTwo.isSubsequence("aaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
			int indexOfChar = t.substring(index)
					.indexOf(s.charAt(i));
			if (indexOfChar == -1) {
                return false;
            }
			index = index + indexOfChar + 1;
        }
        return true;
    }
}
