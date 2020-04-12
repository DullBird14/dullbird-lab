package com.dullbird.demo.leetCode.binary;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cys
 * @date 2019-11-13 12:43
 */

public class ThreeNineTwo {
	public static void main(String[] args) {
		ThreeNineTwo threeNineTwo = new ThreeNineTwo();
		System.out.println(threeNineTwo.isSubsequence("acb", "ahbgdc"));
	}
	public boolean isSubsequence(String s, String t) {
		Set<Character> tSet = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			tSet.add(t.charAt(i));
		}
		for (int i = 0; i < s.length(); i++) {
			if (!tSet.contains(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
