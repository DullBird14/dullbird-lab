package com.dullbird.demo.leetCode;

/**
 * @author cys
 * @date 2019-11-06 7:33 PM
 */

public class FourEightFive {

	public int findMaxConsecutiveOnes(int[] nums) {
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				if (count>maxCount) {
					maxCount = count;
				}
				count = 0;
			}
		}
		return maxCount;
	}
}
