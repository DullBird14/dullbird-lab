package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-11 12:27 PM
 */

public class SixNine {
	public static void main(String[] args) {
		SixNine sixNine = new SixNine();
		System.out.println(sixNine.mySqrt(2147395599));
	}

	public int mySqrt(int x) {
		long start = 0;
		long end = x;
		while (start < end) {
			long mid = (end + start + 1)>>>1;
			if (mid * mid > x) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}
		return (int)start;
	}
//	public int mySqrt(int x) {
//		if (x ==1 || x==0) {
//			return x;
//		}
//
//		return binarySearch(0, x, x);
//	}

//	private int binarySearch(double start, double end, double target) {
//		double mid = start + (end-start)/2;
//		if (start >= end -1) {
//			return (int)mid;
//		}
//
//		double value = mid * mid;
//		if (value > target) {
//			return binarySearch(start, mid, target);
//		} else if(value < target) {
//			return binarySearch(mid, end, target);
//		}
//		return (int) mid;
//	}
}
