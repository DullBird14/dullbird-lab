package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author : cys
 * date: 2021-08-12 23:36
 */
public class Test124 {
    public static void main(String[] args) {
        Test124 test124 = new Test124();
        TreeNode a_1 = new TreeNode(-10);
        TreeNode a_2 = new TreeNode(9);
        TreeNode a_3 = new TreeNode(20);
        TreeNode a_4 = new TreeNode(15);
        TreeNode a_5 = new TreeNode(7);
        a_1.left=a_2;
        a_1.right=a_3;
        a_3.left = a_4;
        a_3.right = a_5;
        int i = test124.maxPathSum(a_1);
        System.out.println(i);
    }
    private int max = -10000;

    public int maxPathSum(TreeNode root) {
        inner(root);
        return max;
    }

    private int inner(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(inner(root.left), 0);
        int rightValue = Math.max(inner(root.right), 0);
        int value = leftValue + rightValue;
        int sumValue = value + root.val;
        if (sumValue > max) {
            max = sumValue;
        }
        return Math.max(leftValue, rightValue) + root.val;
    }
}
