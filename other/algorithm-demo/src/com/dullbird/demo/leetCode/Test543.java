package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-04 14:46
 */
public class Test543 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(1);
        TreeNode a_2 = new TreeNode(2);
        TreeNode a_3 = new TreeNode(3);
        TreeNode a_4 = new TreeNode(4);
        TreeNode a_5 = new TreeNode(5);
        a_2.left = a_4;
        a_2.right = a_5;
        a_1.left = a_2;
        a_1.right = a_3;
        Test543 test543 = new Test543();
        System.out.println(test543.diameterOfBinaryTree(a_1));
    }

    private int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        innerDiameterOfBinaryTree(root);
        return maxLength - 1;
    }

    private int innerDiameterOfBinaryTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftValue = innerDiameterOfBinaryTree(root.left);
        int rightValue = innerDiameterOfBinaryTree(root.right);
        maxLength = Math.max(leftValue + rightValue + 1, maxLength);
        return Math.max(leftValue, rightValue) + 1;
    }
}
