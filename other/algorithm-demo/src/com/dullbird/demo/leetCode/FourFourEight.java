package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author cys
 * @date 2019-11-06 7:14 PM
 */

public class FourFourEight {
	public static void main(String[] args) {
//		int[] array = {1,2,3,4,3,6,7,7,4};
		int[] array = {4,3,2,7,8,2,3,1};
		FourFourEight fourFourEight = new FourFourEight();
		System.out.println(fourFourEight.findDisappearedNumbers(array));
	}
	/**
	 * 异或原地调换值
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			//此处是while不是if，要一直换到相等为止
			while (nums[i] != nums[nums[i]-1]) {
				//交换
				swap(nums, i, nums[i]-1);
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				result.add(i+1);
			}
		}
		return result;
	}

	/**
	 * 原地调换的精髓，异或
	 * @param nums
	 * @param fromIndex
	 * @param toIndex
	 */
	private void swap(int[] nums, int fromIndex, int toIndex) {
		nums[fromIndex] = nums[fromIndex] ^ nums[toIndex];
		nums[toIndex] = nums[fromIndex] ^ nums[toIndex];
		nums[fromIndex] = nums[fromIndex] ^ nums[toIndex];
	}
}
