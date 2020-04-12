package com.dullbird.demo.leetCode.heap;

import java.util.Objects;

/**
 * @author cys
 * @date 2019-12-02 20:32
 */

public class OneZeroFourSix {
	public static void main(String[] args) {
		OneZeroFourSix six = new OneZeroFourSix();
		int[] num = new int[]{1};

		System.out.println(six.lastStoneWeight(num));
	}
	int currentindex;
	int maxIndex;
	int[] array;
	public int lastStoneWeight(int[] stones) {
		array = new int[stones.length + 1];
		maxIndex = stones.length;
		for (int stone : stones) {
			add(stone);
		}
		while (currentindex >=2) {
			int one = this.remove();
			int two = this.remove();
			if (one != two) {
				this.add(one - two);
			}
		}
		if (currentindex == 1) {
			return this.remove();
		}
		return 0;
	}
	private void add(int value) {
		if (currentindex == maxIndex) {
			throw new IllegalStateException("heap full!!");
		}
		int tempIndex = ++currentindex;
		array[tempIndex] = value;
		while (tempIndex/2 >0) {
			if (array[tempIndex] > array[tempIndex/2]) {
				swap(tempIndex, tempIndex/2);
				tempIndex = tempIndex/2;
			} else {
				break;
			}
		}
	}

	private int remove(){
		if (currentindex == 0) {
			throw new IllegalStateException("heap have no element!!");
		}
		int tempIndex = 1;
		int result = array[tempIndex];
		array[tempIndex] = array[currentindex--];
		//如果是引用对象，记得释放
		while (true) {
			int maxIndex = tempIndex;
			if (2 * tempIndex <= currentindex
					&& array[2 * tempIndex] > array[maxIndex] ) {
				maxIndex = 2 * tempIndex;
			}
			if (2 * tempIndex +1 <= currentindex
					&& array[2 * tempIndex +1] > array[maxIndex]) {
				maxIndex = 2 * tempIndex + 1;
			}
			if (maxIndex == tempIndex){
				break;
			}
			swap(tempIndex, maxIndex);
			tempIndex = maxIndex;
		}

		return result;
	}


	private void swap(int from, int to){
		array[from] = array[from] ^ array[to];
		array[to] = array[from] ^ array[to];
		array[from] = array[from] ^ array[to];

	}
}
