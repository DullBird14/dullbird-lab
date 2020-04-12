package com.dullbird.demo.leetCode;

/**
 * https://leetcode-cn.com/problems/missing-number/
 * @author cys
 * @date 2019-11-06 6:52 PM
 */

public class TwoSixEight {
	public static void main(String[] args) {
		TwoSixEight twoSixEight = new TwoSixEight();
		int[] array = new int[]{0,2,3,4};
		System.out.println(twoSixEight.missingNumber(array));
	}

	public int missingNumber(int[] nums) {
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum ^= i ^ nums[i];
		}
		return sum;
	}
}
