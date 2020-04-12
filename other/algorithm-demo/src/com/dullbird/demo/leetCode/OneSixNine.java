package com.dullbird.demo.leetCode;

/**
 * https://leetcode-cn.com/problems/majority-element/submissions/
 * @author cys
 * @date 2019-11-05 8:30 AM
 */

public class OneSixNine {
	public static void main(String[] args) {
		OneSixNine oneSixNine = new OneSixNine();
//		oneSixNine.twoSum();
	}

	public int majorityElement(int[] nums) {
		int num = 0;
		int score = 0;
		for (int num1 : nums) {
			if (score == 0) {
				num = num1;
				score++;
				continue;
			}

			if (num1 != num) {
				score--;
			} else {
				score++;
			}
		}
		return num;
	}
}
