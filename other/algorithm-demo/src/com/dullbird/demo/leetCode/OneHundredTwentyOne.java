package com.dullbird.demo.leetCode;

/**
 * @author cys
 * @date 2019-11-04 7:02 PM
 */

public class OneHundredTwentyOne {
	public static void main(String[] args) {
		OneHundredTwentyOne oneHundredTwentyOne = new OneHundredTwentyOne();
		int[] array = {7,1,5,3,6,4};
		System.out.println(oneHundredTwentyOne.maxProfit(array));
	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		int sum = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			sum += prices[i + 1] - prices[i];
			if (sum < 0) {
				sum = 0;
				continue;
			}
			if (sum > profit) {
				profit = sum;
			}
		}
		return profit;
	}
}
