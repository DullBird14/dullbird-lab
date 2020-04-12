package com.dullbird.demo.leetCode;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author cys
 * @date 2019-11-06 12:23 PM
 */

public class TwoNightThree {
	public static void main(String[] args) {
		TwoNightThree twoNightThree = new TwoNightThree();
		int[] array = new int[]{3,2,2,3};

	}


	public void moveZeroes(int[] nums) {
		int doneIndex = 0;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				int temp = nums[doneIndex];
				nums[doneIndex] = nums[i];
				nums[i] = temp;
				doneIndex++;
			}
			i++;
		}
	}
}
