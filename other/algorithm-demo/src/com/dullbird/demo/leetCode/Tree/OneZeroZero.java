package com.dullbird.demo.leetCode.Tree;


import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cys
 * @date 2019-11-19 19:57
 */

public class OneZeroZero {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		Queue<TreeNode> queueOne = new LinkedList<>();
		Queue<TreeNode> queueTwo = new LinkedList<>();
		queueOne.offer(p);
		queueTwo.offer(q);

		do {
			p = queueOne.poll();
			q = queueTwo.poll();
			if (p == null && q == null){
				continue;
			} else if (p == null) {
				return false;
			} else if (q == null) {
				return false;
			} else if (q.val != p.val) {
				return false;
			} else {
				queueOne.offer(p.left);
				queueOne.offer(p.right);
				queueTwo.offer(q.left);
				queueTwo.offer(q.right);
			}
		} while (queueOne.size() != 0
				|| queueTwo.size() !=0);
		return true;
	}
}
