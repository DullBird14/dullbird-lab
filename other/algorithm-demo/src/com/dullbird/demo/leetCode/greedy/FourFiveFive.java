package com.dullbird.demo.leetCode.greedy;

import java.util.Arrays;

/**
 * @author cys
 * @date 2019-12-03 13:43
 */

public class FourFiveFive {
	public static void main(String[] args) {
		FourFiveFive fourFiveFive = new FourFiveFive();
		int contentChildren = fourFiveFive.findContentChildren(new int[]{1,2}, new int[]{1,2,3});
		System.out.println(contentChildren);
	}
	public int findContentChildren(int[] g, int[] s) {
		int x = 0;
		int y = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		while (x < g.length
				&& y < s.length) {
			if (g[x] <= s[y]) {
				x ++;
				y ++;
			} else {
				y ++;
			}
		}
		return x;
	}

}
