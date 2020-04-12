package com.dullbird.demo.leetCode.binary;

/**
 * @author cys
 * @date 2019-11-13 19:39
 */

public class SevenFourFour {
	public static void main(String[] args) {
		SevenFourFour sevenFourFour = new SevenFourFour();
		char[] chars = {'c','f','j'};

		char j = sevenFourFour.nextGreatestLetter(chars, 'j');
		System.out.println(j);
	}
	public char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;
		int mid ;
		while (left <= right) {
			mid = (left+right)>>>1;
			try {
				Thread.sleep(2000);
				System.out.println("start:" + left + "     " + "end:" + right + "      mid:" + mid);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (letters[mid] <= target ){
				left = mid +1;
			} else {
				if (mid == 0
						|| letters[mid - 1] <= target) {
					return letters[mid];
				}
				right = mid;
			}
		}
		return letters[0];
	}
}
