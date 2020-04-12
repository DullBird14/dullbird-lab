package com.dullbird.demo.geek.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7]
 * @author cys
 * @date 2019-08-10 10:03 PM
 */

public class Tree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> firstQueue = new LinkedList<>();
        Queue<TreeNode> secondQueue = new LinkedList<>();
        firstQueue.offer(root);
        while (firstQueue.size() != 0
                || secondQueue.size() !=0){
            if (firstQueue.size() != 0) {
                result.add(clearQueue(firstQueue, secondQueue));
            } else if (secondQueue.size() !=0) {
                result.add(clearQueue(secondQueue, firstQueue));
            }
        }
        return result;
    }

    private List<Integer> clearQueue(Queue<TreeNode> source, Queue<TreeNode> target) {
        List<Integer> result = new ArrayList<>(source.size());
        do {
            TreeNode node = source.poll();
            if (Objects.nonNull(node.left)) {
                target.offer(node.left);
            }

            if (Objects.nonNull(node.right)) {
                target.offer(node.right);
            }
            result.add(node.val);
        } while (source.size() != 0);
        return result;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
