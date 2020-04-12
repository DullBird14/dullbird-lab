package com.dullbird.demo.leetCode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author cys
 * @date 2019-12-03 12:24
 */

public class ThreeFourSeven {
	public static void main(String[] args) {
		int[] num = new int[]{4,5,8,2,2,2,4};
		ThreeFourSeven seven = new ThreeFourSeven();
		List<Integer> integers = seven.topKFrequent(num, 2);
		System.out.println(integers);
	}

	private PriorityQueue<Integer> queue;
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			Integer integer = map.get(num);
			if (integer == null) {
				integer = 0;
			}
			map.put(num, integer + 1);
		}
		queue = new PriorityQueue<>((o1, o2) -> {
			Integer one = map.get(o1);
			one = one == null? 0 : one;
			Integer two = map.get(o2);
			two = two == null? 0 : two;
			return one - two;
		});
		for (int num : map.keySet()) {
			if (queue.size() >= k) {
				Integer peek = queue.peek();
				if (map.get(num) > map.get(peek)) {
					queue.poll();
					queue.add(num);
				}
			} else {
				queue.add(num);
			}
		}
		return new ArrayList<>(queue);
	}

//
//
//	public List<Integer> topKFrequent(int[] nums, int k) {
//		// build hash map : character and how often it appears
//		HashMap<Integer, Integer> count = new HashMap();
//		for (int n: nums) {
//			count.put(n, count.getOrDefault(n, 0) + 1);
//		}
//
//		// init heap 'the less frequent element first'
//		PriorityQueue<Integer> heap =
//				new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
//
//		// keep k top frequent elements in the heap
//		for (int n: count.keySet()) {
//			heap.add(n);
//			if (heap.size() > k)
//				heap.poll();
//		}
//
//		// build output list
//		List<Integer> top_k = new LinkedList();
//		while (!heap.isEmpty())
//			top_k.add(heap.poll());
//		Collections.reverse(top_k);
//		return top_k;
//	}

}
