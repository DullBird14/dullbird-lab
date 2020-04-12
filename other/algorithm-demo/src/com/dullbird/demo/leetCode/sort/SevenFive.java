package com.dullbird.demo.leetCode.sort;

/**
 * @author cys
 * @date 2019-11-14 20:30
 */

public class SevenFive {
	public void sortColors(int[] nums) {
		int zeroIndex = 0;
		int twoIndex = nums.length -1;
		int currentIndex = 0;
		while (currentIndex <= twoIndex) {
			int num = nums[currentIndex];
			if (num == 0) {
				nums[currentIndex] = nums[zeroIndex];
				nums[zeroIndex] = 0;
				zeroIndex ++;
				currentIndex++;
				continue;
			}
			if (num ==2) {
				nums[currentIndex] = nums[twoIndex];
				nums[twoIndex] = 2;
				twoIndex--;
				continue;
			}
			currentIndex++;
		}
	}
}
