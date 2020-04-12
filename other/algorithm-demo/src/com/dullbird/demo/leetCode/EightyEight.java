package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 有序数组合并
 * @author cys
 * @date 2019-11-04 12:14 PM
 */

public class EightyEight {
	public static void main(String[] args) {
		EightyEight eightyEight = new EightyEight();
//		eightyEight.merge();
//		eightyEight.merge();
//		int[] array = {1,2,3,0,0,0};
//		int[] array2 = {2,5,6};
//		eightyEight.merge(array, 3, array2, 3);
		int[] array = {0};
		int[] array2 = {1};
		eightyEight.merge(array, 0, array2, 1);
		System.out.println(Arrays.toString(array));
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;

		while (i >=0 || j>=0) {
			if (j<0 ||( i>=0 && nums1[i] >= nums2[j])) {
				nums1[i + j + 1] = nums1[i];
				i--;
			} else {
				nums1[i + j + 1] = nums2[j];
				j--;
			}
		}
	}

}
