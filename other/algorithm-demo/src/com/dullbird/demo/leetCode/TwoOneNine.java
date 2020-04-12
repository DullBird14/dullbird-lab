package com.dullbird.demo.leetCode;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @author cys
 * @date 2019-11-05 8:58 PM
 */

public class TwoOneNine {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		LinkedHashSet<Integer> set = new LinkedHashSet();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
