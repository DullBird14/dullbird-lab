package com.dullbird.demo.leetCode.heap;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-27 23:41
 */

public class SevenZeroThree {
	public static void main(String[] args) {
		int[] num = new int[]{4,5,8,2};
		KthLargest kthLargest = new KthLargest(3, num);
		System.out.println(Arrays.toString(kthLargest.minHreap));
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
//		System.out.println(kthLargest.add(3));
//		["KthLargest","add","add","add","add","add"]
//[[2,[0]],[-1],[1],[-2],[-4],[3]]

	}

	static class KthLargest {
		int[] minHreap;
		int maxCount;
		int currentCount = 0;
		public KthLargest(int k, int[] nums) {
			minHreap = new int[k + 1];
			maxCount = k;
			for (int i = nums.length - 1; i >= 0; i--) {
				this.add(nums[i]);
			}
		}

		public int add(int val) {
			//未满。直接添加到末尾
			if (currentCount < maxCount) {
				int index = currentCount + 1;
				minHreap[index] = val;
				while (index/2 >0) {
					if (minHreap[index/2] > val) {
						swap(index/2, index);
						index = index/2;
					} else {
						break;
					}
				}
				currentCount++;
			} else {
				int index = 1;
				int value = minHreap[index];
				if (val <= value) {
					return minHreap[1];
				}
				minHreap[index] = val;
				while (true) {
					int tempIndex = index;
					if (2 * index <= currentCount
							&& minHreap[tempIndex] > minHreap[2 * index]) {
						tempIndex = 2 * index;
					}
					if (2 * index +1 <= currentCount
							&& minHreap[tempIndex] > minHreap[2 * index +1]){
						tempIndex = 2 * index + 1;
					}
					if (tempIndex == index) {break;}
					swap(index, tempIndex);
					index = tempIndex;
				}
			}
			return minHreap[1];
		}

		private void swap(int fromIndex, int toIndex){
			minHreap[fromIndex] = minHreap[fromIndex] ^ minHreap[toIndex];
			minHreap[toIndex] = minHreap[fromIndex] ^ minHreap[toIndex];
			minHreap[fromIndex] = minHreap[fromIndex] ^ minHreap[toIndex];
		}
//		public KthLargest(int k, int[] nums) {
//			minHreap = new Integer[k];
//			for (int i = minHreap.length - 1; i >= 0; i--) {
//				minHreap[i] = Integer.MIN_VALUE;
//			}
//			initHeap(minHreap);
//			for (int i = 0; i < nums.length ; i++) {
//				this.add(nums[i]);
//			}
//		}
//		private void initHeap(Integer[] minHeap) {
//			int halfNodeIndex = (minHeap.length - 1)>>2;
//			for (int nodeIndex = halfNodeIndex; nodeIndex >= 0; nodeIndex--) {
//				int rightIndex = 2 * halfNodeIndex + 2;
//				int leftIndex = 2 * halfNodeIndex + 1;
//				if (rightIndex < minHeap.length
//						&& minHeap[halfNodeIndex] > minHeap[rightIndex]) {
//					int temp = minHeap[rightIndex];
//					minHeap[rightIndex] = minHeap[halfNodeIndex];
//					minHeap[halfNodeIndex] = temp;
//				} else if (leftIndex < minHeap.length
//						&& minHeap[halfNodeIndex] > minHeap[leftIndex]) {
//					int temp = minHeap[leftIndex];
//					minHeap[leftIndex] = minHeap[halfNodeIndex];
//					minHeap[halfNodeIndex] = temp;
//				}
//			}
//		}
//
//		public int add(int val) {
//			Integer min = minHreap[0];
//			if (min ==null) {
//				minHreap[0] = val;
//				return val;
//			}
//			if (val <= min) {
//				return min;
//			}
//			int i =0;
//			minHreap[i] = val;
//
//			while (2 * i +1 < minHreap.length) {
//				int temp ;
//				if (minHreap[i] > minHreap[2 * i +1]) {
//					temp = minHreap[i];
//					minHreap[i] = minHreap[2 * i +1];
//					minHreap[2 * i +1] = temp;
//				}
//				if (2 * i + 2 < minHreap.length
//						&& minHreap[i] > minHreap[2 * i + 2]) {
//					temp = minHreap[i];
//					minHreap[i] = minHreap[2 * i + 2];
//					minHreap[2 * i +2] = temp;
//				}
//				i++;
//			}
//			return minHreap[0];
//		}
//
	}
}
