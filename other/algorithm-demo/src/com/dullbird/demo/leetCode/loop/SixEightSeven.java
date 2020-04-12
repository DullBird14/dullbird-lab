package com.dullbird.demo.leetCode.loop;

import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-17 22:02
 */

public class SixEightSeven {
	public static void main(String[] args) {
		SixEightSeven sixEightSeven = new SixEightSeven();
//		TreeNode a = new TreeNode(5);
//		TreeNode b = new TreeNode(4);
//		TreeNode c = new TreeNode(5);
//		TreeNode d = new TreeNode(1);
//		TreeNode e = new TreeNode(1);
//		TreeNode f = new TreeNode(5);
//		a.right = c;
//		c.right = f;
//		a.left = b;
//		b.left = d;
//		b.right = e;
//		[1,4,5,4,4,5]
//		TreeNode a = new TreeNode(1);
//		TreeNode b = new TreeNode(4);
//		TreeNode c = new TreeNode(5);
//		TreeNode d = new TreeNode(4);
//		TreeNode e = new TreeNode(4);
//		TreeNode f = new TreeNode(5);
//		a.right = c;
//		c.right = f;
//		a.left = b;
//		b.left = d;
//		b.right = e;
//		[1,null,1,1,1,1,1,1]
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(1);
		TreeNode g = new TreeNode(1);
		a.right= b;
		b.left = c;
		b.right = d;
		c.right = f ;
		c.left = e;
		d.left = g;
		sixEightSeven.longestUnivaluePath(a);
		System.out.println(sixEightSeven.max);
	}
	int max = 0;

	public int longestUnivaluePath(TreeNode root) {
		loop(root);
		return max;
	}

	private int loop(TreeNode root) {
		if (Objects.isNull(root)) {
			return 0;
		}

		int leftMax = loop(root.left);
		int rightMax = loop(root.right);
		int leftCurrentMax = 0;
		int rightCurrentMax = 0;
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		if (Objects.nonNull(root.left)
//				&& Objects.equals(root.val, root.left.val)) {
//			leftCurrentMax = leftMax + 1;
//		}
//		if (Objects.nonNull(root.right)
//				&& Objects.equals(root.val, root.right.val)) {
//			rightCurrentMax = rightMax + 1;
//		}
		if (root.left != null && root.left.val == root.val) {
			leftCurrentMax += leftMax + 1;
		}
		if (root.right != null && root.right.val == root.val) {
			rightCurrentMax += rightMax + 1;
		}
		max = Math.max(max, leftCurrentMax + rightCurrentMax);
//		System.out.println("current:value:" + root.val + "\t left:" + root.left
//				+ "\t right:" + root.right + "\t " + leftMax + "\t" +rightMax +"\t" +max);
		return Math.max(leftCurrentMax, rightCurrentMax);
	}

}
