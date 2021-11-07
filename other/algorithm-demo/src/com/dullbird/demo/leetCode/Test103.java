package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-07 22:57
 */
public class Test103 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queueOne = new LinkedList<>();
        LinkedList<TreeNode> queueTwo = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queueOne.add(root);
        while (!queueOne.isEmpty()
                || !queueTwo.isEmpty()) {
            List<Integer> tempResult = new ArrayList<>();
            while (!queueOne.isEmpty()) {
                TreeNode treeNode = queueOne.pollLast();
                if (treeNode == null) {
                    continue;
                }
                tempResult.add(treeNode.val);
                if (treeNode.left !=null) {
                    queueTwo.addLast(treeNode.left);
                }
                if (treeNode.right !=null) {
                    queueTwo.addLast(treeNode.right);
                }
            }
            if (!tempResult.isEmpty()) {
                result.add(tempResult);
                tempResult = new ArrayList<>();
            }
            while (!queueTwo.isEmpty()) {
                TreeNode treeNode = queueTwo.pollLast();
                if (treeNode == null) {
                    continue;
                }
                tempResult.add(treeNode.val);

                if (treeNode.right !=null) {
                    queueOne.addLast(treeNode.right);
                }
                if (treeNode.left !=null) {
                    queueOne.addLast(treeNode.left);
                }
            }
            if (!tempResult.isEmpty()) {
                result.add(tempResult);
            }
        }
        return result;
    }
}
