package com.dullbird.demo.leetCode;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author cys
 * @date 2019-11-03 8:19 PM
 */

public class TwentySeven {
	public static void main(String[] args) {
		TwentySeven twentySeven = new TwentySeven();
//		int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//		int[] array = new int[]{1, 1, 2};
		int[] array = new int[]{3,2,2,3};

		System.out.println(twentySeven.removeElement(array, 3));
	}

	public int removeElement(int[] nums, int val) {
		int realArrayIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val){
				continue;
			} if (i != realArrayIndex){
				nums[realArrayIndex] = nums[i];
			}
			realArrayIndex ++;
		}
		return realArrayIndex;
	}
}
