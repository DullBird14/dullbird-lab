package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author : cys
 * date: 2021-09-07 13:06
 */
public class Test112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum - root.val == 0
                && root.left == null
                && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);

    }
}
