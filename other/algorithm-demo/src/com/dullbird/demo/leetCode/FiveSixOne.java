package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 * @author cys
 * @date 2019-11-06 7:45 PM
 */

public class FiveSixOne {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum =0;
		for (int i = 0; i < nums.length; i = i + 2) {
			sum += nums[i];
		}
		return sum;
	}
}
