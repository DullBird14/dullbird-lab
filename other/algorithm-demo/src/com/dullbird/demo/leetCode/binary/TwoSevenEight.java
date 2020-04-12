package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-11 20:31
 */

public class TwoSevenEight {

	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left < right){
			int mid = (left + right)>>>1;
			if (!isBadVersion(mid)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	boolean isBadVersion(int version){
		return false;
	}
}
