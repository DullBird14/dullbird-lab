package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-17 13:06
 */
public class Test98 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(5);
        TreeNode a_2 = new TreeNode(4);
        TreeNode a_3 = new TreeNode(6);
        TreeNode a_4 = new TreeNode(3);
        TreeNode a_5 = new TreeNode(7);
        a_3.left = a_4;
        a_3.right = a_5;
        a_1.left = a_2;
        a_1.right = a_3;
        Test98 test98 = new Test98();
        System.out.println(test98.isValidBST(a_1));

    }

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
//        System.out.println(root.val);
        boolean current;
        if (pre == null) {
            current = true;
        } else if (root.val > pre) {
            current = true;
        } else {
            return false;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left && current && right;
    }

}
