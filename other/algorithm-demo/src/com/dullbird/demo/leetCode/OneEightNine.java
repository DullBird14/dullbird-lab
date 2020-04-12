package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * @author cys
 * @date 2019-11-05 8:30 PM
 */

public class OneEightNine {
	public static void main(String[] args) {
		OneEightNine oneEightNine = new OneEightNine();
//		int[] array = {1,2,3,4,5,6,7};
		int[] array = {-1};

		oneEightNine.rotate(array, 2);
		System.out.println(Arrays.toString(array));
	}

	public void rotate(int[] nums, int k) {
		//很关键，否则数组长度为2，移动10格，直接报错
		k %= nums.length;
		reverseArray(nums, 0, nums.length-1);
		reverseArray(nums, 0, k-1);
		reverseArray(nums, k, nums.length-1);
	}

	private void reverseArray(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}
}
