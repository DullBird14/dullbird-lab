package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author cys
 * @date 2019-12-27 23:14
 */

public class FourZeroFour {
//	public int sumOfLeftLeaves(TreeNode root) {
//		return 0;
//	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left !=null
				&& root.left.left ==null
				&& root.left.right ==null) {
			sum = root.left.val;
		} else {
			sum += sumOfLeftLeaves(root.left);
		}
		sum += sumOfLeftLeaves(root.right);

		return sum;
	}
}
