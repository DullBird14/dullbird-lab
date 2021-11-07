package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.LinkedList;

/**
 * @author : cys
 * date: 2021-08-28 17:49
 */
public class Test958 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(1);
        TreeNode a_2 = new TreeNode(2);
        TreeNode a_3 = new TreeNode(3);
        TreeNode a_4 = new TreeNode(4);
        TreeNode a_5 = new TreeNode(5);
        TreeNode a_6 = new TreeNode(6);
        a_1.left = a_2;
        a_1.right = a_3;
        a_2.left = a_4;
        a_2.right = a_5;
        a_3.left = a_6;
        Test958 test958 = new Test958();
        System.out.println(test958.isCompleteTree(a_1));
    }

    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean endMark = false;
        while (true) {
            TreeNode treeNode = queue.removeFirst();
            if (treeNode == null) {
                return queue.isEmpty();
            }
            if (treeNode.left != null) {
                queue.addLast(treeNode.left);
            } else if (!endMark) {
                endMark = true;
                queue.addLast(null);
            }
            if (treeNode.right != null) {
                queue.addLast(treeNode.right);
            } else if (!endMark) {
                endMark = true;
                queue.addLast(null);
            }
        }
    }
}
