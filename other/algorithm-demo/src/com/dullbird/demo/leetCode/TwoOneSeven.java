package com.dullbird.demo.leetCode;

import java.util.HashSet;

/**
 * @author cys
 * @date 2019-11-05 8:46 PM
 */

public class TwoOneSeven {
	public boolean containsDuplicate(int[] nums) {
		HashSet hash = new HashSet();
		for (int num : nums) {
			if (hash.contains(num)) {
				return true;
			}
			hash.add(num);
		}
		return false;
	}
}
