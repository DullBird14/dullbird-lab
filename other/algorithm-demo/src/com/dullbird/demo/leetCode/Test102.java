package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-18 13:48
 */
public class Test102 {
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
        Test102 test102 = new Test102();
        System.out.println(test102.levelOrder(a_1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queueOne = new LinkedList<>();
        LinkedList<TreeNode> queueTwo = new LinkedList<>();
        queueOne.addLast(root);

        List<Integer> tempList = new ArrayList<>();
        while (!queueOne.isEmpty()
                || !queueTwo.isEmpty()) {
            LinkedList<TreeNode> hasDataQueue = queueOne.isEmpty() ? queueTwo : queueOne;
            LinkedList<TreeNode> putDataQueue = queueOne.isEmpty() ? queueOne : queueTwo;
            while (!hasDataQueue.isEmpty()) {
                TreeNode treeNode = hasDataQueue.pollFirst();
                tempList.add(treeNode.val);
                if (treeNode.left !=null) {
                    putDataQueue.addLast(treeNode.left);
                }
                if (treeNode.right !=null) {
                    putDataQueue.addLast(treeNode.right);
                }
            }
            result.add(tempList);
            tempList = new ArrayList<>();
        }
        return result;
    }
}
