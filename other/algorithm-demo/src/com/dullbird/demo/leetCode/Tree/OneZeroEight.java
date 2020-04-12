package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;


/**
 * @author cys
 * @date 2019-12-16 20:42
 */

public class OneZeroEight {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums ==null) {
			return null;
		}
		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}
		return bFsSearch(nums, 0, nums.length-1);
	}
	public TreeNode bFsSearch(int[] nums, int from, int to){
		if (from > to) {
			return null;
		}
		int num = (from + to) >>> 1;
		TreeNode root = new TreeNode(nums[num]);
		root.left = bFsSearch(nums, from, num - 1);
		root.right = bFsSearch(nums, num +1, to);
		return root;
	}
}
