package com.dullbird.demo.leetCode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 * @author cys
 * @date 2019-11-03 10:42 PM
 */

public class ThirtyFive {

	public static void main(String[] args) {
	    ThirtyFive thirtyFive = new ThirtyFive();
//	    thirtyFive.searchInsert()
	}

	/**
	 * 简单方法
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
		int i =0;
		while (i < nums.length) {
			if (nums[i] == target) {
				return i;
			}
			i++;
		}
		return i;
	}
}
