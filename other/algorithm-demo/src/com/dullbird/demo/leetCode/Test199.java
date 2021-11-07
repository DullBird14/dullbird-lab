package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-07 22:30
 */
public class Test199 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(1);
        TreeNode a_2 = new TreeNode(2);
        TreeNode a_3 = new TreeNode(3);
        TreeNode a_4 = new TreeNode(4);
        TreeNode a_5 = new TreeNode(5);
        a_1.left = a_2;
//        a_1.right = a_3;
//        a_2.right = a_5;
//        a_3.right = a_4;
        Test199 test199 = new Test199();
        List<Integer> integers = test199.rightSideView(a_1);
        System.out.println(integers);
    }

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queueOne = new LinkedList<>();
        LinkedList<TreeNode> queueTwo = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queueOne.add(root);
        while (!queueOne.isEmpty()
                || !queueTwo.isEmpty()) {
            LinkedList<TreeNode> queue = queueOne.isEmpty() ? queueTwo : queueOne;
            LinkedList<TreeNode> queuePut = queueOne.isEmpty() ? queueOne : queueTwo;
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode == null) {
                    continue;
                }
                if (queue.isEmpty()) {
                    result.add(treeNode.val);
                }
                if (treeNode.left !=null) {
                    queuePut.add(treeNode.left);
                }
                if (treeNode.right !=null) {
                    queuePut.add(treeNode.right);
                }
            }
        }
        return result;
    }
}
