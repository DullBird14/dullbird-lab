package com.dullbird.demo.leetCode.greedy;

import java.util.PriorityQueue;

/**
 * @author cys
 * @date 2019-12-12 12:44
 */

public class OneZeroZeroFive {

	public int largestSumAfterKNegations(int[] A, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i : A) {
			queue.add(i);
		}
		for (int i = 0; i < K; i++) {
			Integer poll = queue.poll();
			queue.add(poll * -1);
		}
		int sum = queue.stream().mapToInt(e -> e).sum();
		return sum;
	}
}
