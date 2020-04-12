package com.dullbird.demo.leetCode;

import java.util.Arrays;
import java.util.Objects;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author cys
 * @date 2019-11-03 8:19 PM
 */

public class TwentyFive {
	public static void main(String[] args) {
		TwentyFive twentyFive = new TwentyFive();
//		int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int[] array = new int[]{1, 1, 2};
		int i = twentyFive.removeDuplicates(array);
		System.out.println(i);
	}

	/**
	 * 没有注意是有序数组
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length ==0) {
			return 0;
		}
		if (nums.length ==1) {
			return 1;
		}

		int slow = 0;
		int fast = 1;
		while (fast < nums.length) {
			if (nums[slow] == nums[fast]) {
				fast++;
			} else {
				nums[++slow] = nums[fast++];
			}
		}
		return slow + 1;
	}

	/**
	 * 可以针对无序数组
	 * @param nums
	 * @return
	 */
	public int removeDuplicatesUnOrderedArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int index = 0;
		int doneIndex = 0;
		int disableIndex = nums.length-1;
		while (doneIndex <= disableIndex) {
			int org = nums[index];
			boolean tag =false;
			for (int i = 0; i < doneIndex; i++) {
				if (nums[i] == org) {
					tag = true;
					break;
				}
			}
			if (tag) {
				int temp = nums[index];
				nums[index] = nums[disableIndex];
				nums[disableIndex] = temp;
				disableIndex--;
				continue;
			}
			doneIndex++;
			index++;
		}
		System.out.println(Arrays.toString(nums));
		return doneIndex;
	}
}
