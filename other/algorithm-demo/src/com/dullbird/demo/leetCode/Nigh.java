package com.dullbird.demo.leetCode;

import java.util.Objects;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @author cys
 * @date 2019-10-31 1:04 PM
 */
public class Nigh {
	public static void main(String[] args) {
		Nigh nigh = new Nigh();
		System.out.println(nigh.isPalindrome2(1221));
	}


	public boolean isPalindrome2(int x) {
		//注意x !=0
		if (x < 0 || (x % 10 == 0 && x !=0)) {
			return false;
		}
		int reverse = 0;
		//取一半反转
		while (x > reverse){
			reverse = reverse * 10 + x % 10;
			x = x/10;
		}
		//奇偶的判断
		return x == reverse || x == reverse/10;
	}

	public boolean isPalindrome(int x) {
		String value = String.valueOf(x);
		int i = 0;
		int j = value.length()-1;
		while (i<j) {
			if (!Objects.equals(value.charAt(i++), value.charAt(j--))) {
				return false;
			}
		}
		return true;
	}


}
