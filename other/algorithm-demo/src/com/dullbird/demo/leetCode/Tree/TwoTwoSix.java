package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author cys
 * @date 2019-11-19 20:24
 */

public class TwoTwoSix {

	public TreeNode invertTree(TreeNode root) {
		changeNode(root);
		return root;
	}

	private void changeNode(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
		changeNode(root.left);
		changeNode(root.right);
	}
}
