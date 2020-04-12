package com.dullbird.demo.leetCode.greedy;

/**
 * @author cys
 * @date 2019-12-06 23:56
 */

public class OneTwoTwoOne {
	public int balancedStringSplit(String s) {
		char temp = ' ' ;
		int count = 0;
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (' ' == temp) {
				temp = c;
				num ++;
			} else if (c == temp) {
				num ++;
			} else {
				num--;
			}
			if (num == 0) {
				count++;
				temp=' ';
			}
		}
		return count;
	}
}
