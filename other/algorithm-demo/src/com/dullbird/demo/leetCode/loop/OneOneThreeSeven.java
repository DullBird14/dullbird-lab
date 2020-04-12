package com.dullbird.demo.leetCode.loop;


import java.util.Arrays;

/**
 * @author cys
 * @date 2019-11-18 23:41
 */

public class OneOneThreeSeven {
	private int[] mem;
	public static void main(String[] args) {
		OneOneThreeSeven oneOneThreeSeven = new OneOneThreeSeven();

		System.out.println(oneOneThreeSeven.tribonacci(35));
	}
	public int tribonacci(int n) {
		mem = new int[n + 1];
		//可以利用剪枝优化
		Arrays.fill(mem, -1);
		return getTribonacci(n);

	}

	private int getTribonacci(int n) {
		if (n==0) {
			return 0;
		} else if (n==1
				|| n==2) {
			return 1;
		}

		if (mem[n] == -1) {
			mem[n] = getTribonacci(n - 3) + getTribonacci(n - 2) + getTribonacci(n - 1);
		}

		return mem[n];
	}

}
