package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-12 12:37
 */

public class ThreeSevenFour {
	public static void main(String[] args) {
		ThreeSevenFour threeSevenFour = new ThreeSevenFour();
		int i = threeSevenFour.guessNumber(10);
		System.out.println(i);
	}

	public int guessNumber(int n) {
		int left = 0;
		int mid ;
		int right = n;
		while (left <= right) {
			mid = (left + right + 1) >>>1;
			try {
				Thread.sleep(2000);
				System.out.println("start:" + left + "     " + "end:" + right + "      mid:" + mid);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (guess(mid) == 0) {
				return mid;
			} else if (guess(mid) == 1) {
				right = mid -1;
			} else {
				left = mid;
			}
		}
		return -1;
	}
	private int guess(int num){
		if (num>6) {
			return 1;
		}
		if (num<6){
			return -1;
		}
		return 0;
	}
}
