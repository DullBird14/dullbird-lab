package com.dullbird.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-11 17:21
 */
public class Test32_3 {
    public static void main(String[] args) {
        Test32_3 test32_3 = new Test32_3();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = new TreeNode(4);
        treeNode.left = treeNode1;
        TreeNode treeNode2 = new TreeNode(3);
        treeNode2.right = new TreeNode(5);
        treeNode.right = treeNode2;

        List<List<Integer>> lists = test32_3.levelOrder(treeNode);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> oneQueue = new LinkedList<>();
        LinkedList<TreeNode> twoQueue = new LinkedList<>();
        oneQueue.push(root);
        int i = 0;
        while (!oneQueue.isEmpty()
                || !twoQueue.isEmpty()) {
            LinkedList<TreeNode> loopQueue = oneQueue.isEmpty() ? twoQueue : oneQueue;
            LinkedList<TreeNode> addQueue = oneQueue.isEmpty() ? oneQueue : twoQueue;
            List<Integer> tempResult = new ArrayList<>();
            while (!loopQueue.isEmpty()) {
                TreeNode pop;
                pop = loopQueue.pollLast();
                tempResult.add(pop.val);
                if (i % 2 == 0) {
//                    pop = loopQueue.pollFirst();
//                    tempResult.add(pop.val);
                    if (null != pop.left) {
                        addQueue.add(pop.left);
                    }
                    if (null != pop.right) {
                        addQueue.add(pop.right);
                    }
                } else {
//                    pop = loopQueue.pollLast();
//                    tempResult.add(pop.val);
                    if (null != pop.right) {
                        addQueue.add(pop.right);
                    }
                    if (null != pop.left) {
                        addQueue.add(pop.left);
                    }
                }

            }
            i++;
            result.add(tempResult);
        }
        return result;
    }

}
