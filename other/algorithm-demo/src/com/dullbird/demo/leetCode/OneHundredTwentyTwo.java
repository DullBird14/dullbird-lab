package com.dullbird.demo.leetCode;

/**
 * @author cys
 * @date 2019-11-04 7:02 PM
 */

public class OneHundredTwentyTwo {
	public static void main(String[] args) {
		OneHundredTwentyTwo oneHundredTwentyOne = new OneHundredTwentyTwo();
		int[] array = {7,1,5,3,6,4};
		System.out.println(oneHundredTwentyOne.maxProfit(array));
	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int daily = prices[i + 1] - prices[i];
			if (daily > 0) {
				profit += daily;
			}
		}
		return profit;
	}
}
