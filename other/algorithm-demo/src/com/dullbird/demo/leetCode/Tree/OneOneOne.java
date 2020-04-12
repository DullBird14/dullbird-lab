package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * 广度优先更合适
 * @author cys
 * @date 2019-12-26 19:55
 */

public class OneOneOne {
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		one.left = two;
		OneOneOne oneOneOne = new OneOneOne();
		int i = oneOneOne.minDepth(one);
		System.out.println(i);
	}
	public int minDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		int leftMin = minDepth(root.left);
		int rightMin = minDepth(root.right);
		if (leftMin == 0
				&& rightMin ==0) {
			return 1;
		}
		if (leftMin != 0
				&& rightMin == 0) {
			return leftMin + 1;
		}
		if (leftMin == 0) {
			return rightMin + 1;
		}
		return Math.min(leftMin, rightMin) +1;
	}
}
