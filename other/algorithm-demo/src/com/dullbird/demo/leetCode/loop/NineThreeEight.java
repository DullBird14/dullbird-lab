package com.dullbird.demo.leetCode.loop;

/**
 * @author cys
 * @date 2019-11-19 19:33
 */

public class NineThreeEight {
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}
		int max = 0;
		if (root.val < L) {
			max += rangeSumBST(root.right, L, R);
		} else if (root.val > R) {
			max += rangeSumBST(root.left, L, R);
		} else {
			max += rangeSumBST(root.right, L, R);
			max += rangeSumBST(root.left, L, R);
			max += root.val;
		}
		return max;
	}

}

