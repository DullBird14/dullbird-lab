package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author : cys
 * date: 2021-08-12 00:34
 */
public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node, TreeNode compareNode) {
        if (node == null && compareNode == null) {
            return true;
        }

        if (node == null || compareNode == null) {
            return false;
        }
        return node.val == compareNode.val
                && isSymmetric(node.left, compareNode.right)
                && isSymmetric(node.right, compareNode.left);
    }
}
