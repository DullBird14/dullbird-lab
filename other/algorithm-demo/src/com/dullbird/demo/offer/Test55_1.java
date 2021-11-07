package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-24 17:35
 */
public class Test55_1 {
    public int maxDepth(TreeNode root) {
        return innerMaxDepth(root);
    }

    private int innerMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(
                innerMaxDepth(root.left),
                innerMaxDepth(root.right)) + 1;
    }
}
