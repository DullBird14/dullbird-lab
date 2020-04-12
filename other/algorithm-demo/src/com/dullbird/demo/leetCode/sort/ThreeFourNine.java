package com.dullbird.demo.leetCode.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author cys
 * @date 2019-11-14 19:19
 */

public class ThreeFourNine {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length==0
				|| nums2.length==0) {
			return new int[0];
		}
		List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
		list1.retainAll(list2);
		return list1.stream().distinct().mapToInt(Integer::intValue).toArray();

	}
}
