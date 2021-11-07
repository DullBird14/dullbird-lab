package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-07 00:20
 */
public class Test114 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(1);
        TreeNode a_2 = new TreeNode(2);
        TreeNode a_3 = new TreeNode(3);
        TreeNode a_4 = new TreeNode(4);
        TreeNode a_5 = new TreeNode(5);
        TreeNode a_6 = new TreeNode(6);
        a_1.left = a_2;
        a_1.right = a_5;
        a_5.right = a_6;
        a_2.left = a_3;
        a_2.right = a_4;
        Test114 test114 = new Test114();
        test114.flatten(a_1);
    }
//    private TreeNode watch ;
    public void flatten(TreeNode root) {
//        watch = root;
        TreeNode pre = new TreeNode();
        TreeNode head = new TreeNode();
        head.right = pre;
        innerFlatten(root, head);
    }

    private void innerFlatten(TreeNode root, TreeNode head) {
        if (Objects.isNull(root)) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = null;
        root.left = null;
        head.right.right = root;
        head.right = root;
        innerFlatten(left, head);
        innerFlatten(right, head);
    }
}
