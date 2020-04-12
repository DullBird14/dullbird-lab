package com.dullbird.demo.leetCode.sort;

/**
 * @author cys
 * @date 2019-11-14 19:38
 */

public class NineTwoTwo {
//	[3,4]
	public int[] sortArrayByParityII(int[] A) {
		int ouIndex = 0;
		int jiIndex = 1;
		while ( ouIndex <= A.length-1
				&& jiIndex <= A.length-1) {
			if (A[ouIndex]%2==0) {
				ouIndex += 2;
				continue;
			}
			if (A[jiIndex]%2==1) {
				jiIndex += 2;
				continue;
			}
			A[jiIndex] = A[jiIndex] ^ A[ouIndex];
			A[ouIndex] = A[jiIndex] ^ A[ouIndex];
			A[jiIndex] = A[jiIndex] ^ A[ouIndex];
			ouIndex += 2;
			jiIndex += 2;
		}
		return A;
	}
}
