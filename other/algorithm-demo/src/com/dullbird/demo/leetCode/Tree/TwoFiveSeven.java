package com.dullbird.demo.leetCode.Tree;

import com.dullbird.demo.leetCode.loop.TreeNode;
import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cys
 * @date 2019-12-27 22:53
 */

public class TwoFiveSeven {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		binaryTreePaths(root, list, "");
		return list;
	}

	private void binaryTreePaths(TreeNode root, List<String> list, String path) {

		if (path == "") {
			path = String.valueOf(root.val);
		} else {
			path = path + "->" + root.val;
		}
		//todo 不是节点为null就是叶子节点
		if (root.right == null
				&& root.left ==null) {
			list.add(path);
			return;
		}
		if (root.left!=null) {
			binaryTreePaths(root.left, list, path);
		}
		if (root.right!=null) {
			binaryTreePaths(root.right, list, path);
		}
	}


}
