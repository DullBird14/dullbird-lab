package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author cys
 * @date 2020-01-02 23:07
 */

public class FiveThreeZero {
	private int preValue = Integer.MAX_VALUE;
	public int getMinimumDifference(TreeNode root) {
		return lDRSearch(root);
	}

	private int lDRSearch(TreeNode root) {
		if (root.left == null
				&& root.right == null){
			int abs = Math.abs(preValue - root.val);
			preValue = root.val;
			return abs;
		}
		int leftValue = Integer.MAX_VALUE;
		if (root.left!=null) {
			leftValue = lDRSearch(root.left);
		}
		int currentValue = Math.abs(root.val- preValue);
		preValue = root.val;
		int rightValue = Integer.MAX_VALUE;
		if (root.right!=null) {
			rightValue = lDRSearch(root.right);
		}
		return Math.min(Math.min(leftValue, currentValue), rightValue);
	}
}
