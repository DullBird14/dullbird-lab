package com.dullbird.demo.leetCode.loop;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-18 19:18
 */

public class SevenEightThree {
//	private LinkedList<Integer> linkedList = new LinkedList<>();
	TreeNode pre =null;
	int minMax = Integer.MAX_VALUE;
	public int minDiffInBST(TreeNode root) {
		loop(root);
		return minMax;
	}

	private void loop(TreeNode root) {
		if (root ==null) {
			return;
		}
		loop(root.left);
		if (pre != null) {
			minMax = Math.min(Math.abs(pre.val-root.val), minMax);
		}
		pre = root;
		loop(root.right);
	}

}
