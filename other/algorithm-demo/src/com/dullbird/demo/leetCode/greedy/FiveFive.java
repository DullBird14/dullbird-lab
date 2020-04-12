package com.dullbird.demo.leetCode.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cys
 * @date 2019-12-07 00:07
 */

public class FiveFive {
	public boolean canJump(int[] nums) {
		int lastGood = nums.length -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= lastGood) {
				lastGood = i;
			}
		}
		return lastGood == 0;
	}
}
