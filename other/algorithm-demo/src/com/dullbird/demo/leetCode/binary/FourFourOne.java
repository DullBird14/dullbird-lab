package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-13 13:00
 */

public class FourFourOne {
	public static void main(String[] args) {
		FourFourOne threeSixSeven = new FourFourOne();
		int i = threeSixSeven.arrangeCoins(3);
		System.out.println(i);
	}
	public int arrangeCoins(int n) {
		long left = 0;
		long right = n;
		long mid;
		while (left<right) {
			mid = (left + right + 1)>>>1;
//			try {
//				Thread.sleep(2000);
//				System.out.println("start:" + left + "     " + "end:" + right + "      mid:" + mid);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			long value = (mid + 1) * mid/2;
			if (value > n ) {
				right = mid -1;
			} else  {
				left = mid;
			}
		}
		return (int)left;
	}
}
