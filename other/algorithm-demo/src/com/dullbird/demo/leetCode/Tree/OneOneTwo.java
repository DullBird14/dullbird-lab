package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author cys
 * @date 2019-12-26 12:46
 */

public class OneOneTwo {
	private boolean ifFind;
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		search(root, 0, sum);
		return ifFind;
	}

	private void search(TreeNode root, int sum, int target){
		if (ifFind) {
			return;
		}
		sum += root.val;
		if (root.left == null
				&& root.right == null
				&& sum == target){
			ifFind = true;
			return;
		}

		if (root.left != null) {
			search(root.left, sum, target);
		}

		if (root.right != null) {
			search(root.right, sum, target);
		}
	}
}
