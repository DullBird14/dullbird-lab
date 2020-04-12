package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-25 20:40
 */

public class OneZeroOne {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null
				&& right == null) {
			return true;
		} else if (left == null
				|| right == null) {
			return false;
		} else if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}
}
