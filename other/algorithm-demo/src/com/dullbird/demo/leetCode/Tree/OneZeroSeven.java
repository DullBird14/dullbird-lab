package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cys
 * @date 2019-12-16 20:21
 */

public class OneZeroSeven {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<List<Integer>> list = new ArrayList<>();
		if (root ==null) {
			return Collections.emptyList();
		}
		LinkedList<TreeNode> treeNodeQueue = new LinkedList<>();
		treeNodeQueue.add(root);
		while (!treeNodeQueue.isEmpty()){
			ArrayList<Integer> innerList = new ArrayList<>();
			int size = treeNodeQueue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = treeNodeQueue.removeLast();
				innerList.add(poll.val);
				if (poll.left!=null) {
					treeNodeQueue.addFirst(poll.left);

				}
				if (poll.right!=null) {
					treeNodeQueue.addFirst(poll.right);

				}
			}
			list.add(innerList);
		}
		Collections.reverse(list);
		return list;
	}
}
