package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-12 12:09
 */

public class ThreeSixSeven {
	public static void main(String[] args) {
		System.out.println(Math.sqrt(808201));
		ThreeSixSeven threeSixSeven = new ThreeSixSeven();
		threeSixSeven.isPerfectSquare(808201);
	}
	public boolean isPerfectSquare(int num) {
		long start = 0;
		long end = num;
		while (start <= end) {
			long mid = (start + end + 1) >>>1;
//			try {
//				Thread.sleep(2000);
//				System.out.println("start:" + start + "     " + "end:" + end + "      mid:" + mid);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			if (mid * mid ==num) {
				return true;
			}
			if ((mid * mid) > num) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}

		return false;
	}

}
