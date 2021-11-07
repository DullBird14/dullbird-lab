package com.dullbird.demo.leetCode.loop;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author cys
 * @date 2019-11-19 19:41
 */

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int x) { val = x; }

	@Override
	public String toString() {
		return "TreeNode{" +
				"val=" + val +"}'";
	}
}
