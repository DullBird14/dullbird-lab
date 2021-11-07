package com.dullbird.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-11 17:21
 */
public class Test32_2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> oneQueue = new LinkedList<>();
        LinkedList<TreeNode> twoQueue = new LinkedList<>();
        oneQueue.push(root);
        while (true) {
            if (oneQueue.isEmpty()
                    && twoQueue.isEmpty()) {
                break;
            }
            LinkedList<TreeNode> loopQueue = oneQueue.isEmpty() ? twoQueue : oneQueue;
            LinkedList<TreeNode> addQueue = oneQueue.isEmpty() ? oneQueue : twoQueue;

            List<Integer> tempResult = new ArrayList<>();
            while (!loopQueue.isEmpty()) {
                TreeNode pop = loopQueue.pollFirst();
                tempResult.add(pop.val);
                if (null != pop.left) {
                    addQueue.add(pop.left);
                }
                if (null != pop.right) {
                    addQueue.add(pop.right);
                }
            }
            result.add(tempResult);
        }
        return result;
    }

}
