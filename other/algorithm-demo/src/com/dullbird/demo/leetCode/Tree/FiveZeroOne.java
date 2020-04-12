package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cys
 * @date 2020-01-02 20:19
 */

public class FiveZeroOne {
	private Set<Integer> resultNumList = new HashSet<>();
	private int currentNumCount = 0;
	private int maxCount = 0;
	private Integer currentNum = null;

	public int[] findMode(TreeNode root) {
		lDRSearch(root);
		int[] intArray = new int[resultNumList.size()];
		int i = 0;
		for (Integer integer : resultNumList) {
			intArray[i++] = integer;
		}
		return intArray;
	}

	private void lDRSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		lDRSearch(root.left);
		if (currentNum == null) {
			currentNumCount ++;
			currentNum = root.val;
		} else if (currentNum == root.val) {
			currentNumCount++;
		} else {
			currentNumCount = 1;
			currentNum = root.val;
		}

		if (currentNumCount == maxCount) {
			resultNumList.add(root.val);
		} else if (currentNumCount > maxCount) {
			resultNumList.clear();
			resultNumList.add(root.val);
			maxCount = currentNumCount;
		}
		lDRSearch(root.right);
	}
}
