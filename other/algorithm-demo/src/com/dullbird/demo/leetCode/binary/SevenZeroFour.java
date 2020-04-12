package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-13 20:42
 */

public class SevenZeroFour {
	public static void main(String[] args) {
		SevenZeroFour sevenFourFour = new SevenZeroFour();
		int[] chars = {-1,0,3,5,9,12};

		System.out.println(sevenFourFour.search(chars, 9));
	}
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length -1;
		int mid;
		while (left <= right) {
			mid = (left + right)>>>1;
			try {
				Thread.sleep(2000);
				System.out.println("start:" + left + "     " + "end:" + right + "      mid:" + mid);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target){
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
