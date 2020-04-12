package com.dullbird.demo.leetCode;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author cys
 * @date 2019-11-05 8:30 AM
 */

public class OneSixSeven {
	public static void main(String[] args) {
		OneSixSeven oneSixNine = new OneSixSeven();
//		oneSixNine.twoSum();
	}

	public int[] twoSum(int[] numbers, int target) {
		int minIndex = 0;
		int maxIndex = numbers.length - 1;
		while (maxIndex > minIndex) {
			int sum = numbers[minIndex] + numbers[maxIndex];
			if ( sum == target) {
				return new int[]{minIndex+1, maxIndex+1};
			} else if (sum > target) {
				maxIndex--;
			} else {
				minIndex++;
			}
		}
		return new int[]{minIndex+1, maxIndex+1};
	}
}
