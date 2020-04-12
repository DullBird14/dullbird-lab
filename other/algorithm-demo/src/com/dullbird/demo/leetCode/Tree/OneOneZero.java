package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author cys
 * @date 2019-12-26 19:45
 */

public class OneOneZero {
	boolean mark = true;

	public boolean isBalanced(TreeNode root) {
		isBalancedNum(root);
		return mark;
	}


	private int isBalancedNum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (!mark) {
			return 0;
		}

		int leftNum = isBalancedNum(root.right);
		int rightNum = isBalancedNum(root.left);
		if (Math.abs(leftNum - rightNum) >1) {
			mark =false;
		}
		return Math.max(leftNum, rightNum) +1;
	}


}
