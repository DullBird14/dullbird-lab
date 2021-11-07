package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-24 17:40
 */
public class Test55_2 {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        innerIsBalanced(root);
        return result;
    }

    private int innerIsBalanced(TreeNode root) {
        if (root == null
                || !result) {
            return 0;
        }
        int left = innerIsBalanced(root.left);
        int right = innerIsBalanced(root.right);
        if (Math.abs(left-right) > 1) {
            result = false;
            return -1;
        }
        return Math.max(
                left,
                right) + 1;
    }

}
