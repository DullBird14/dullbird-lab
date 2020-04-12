package com.dullbird.demo.leetCode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author cys
 * @date 2019-10-31 1:04 PM
 */

public class Seven {
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
	    Seven a = new Seven();
		int reverse = a.reverse(-123);
		System.out.println(reverse);
	}
	public int reverse(int x) {
		int result = 0;
		do {
			int temp = result;
			result = result * 10 + x%10;
			//记录上一次的状态，并且和下一次比较。
			// 如果溢出了，。值就不相等了
			if (temp != result/10) {
				return 0;
			}
			x = x/10;
		} while(x != 0);

		return result;
	}
}
