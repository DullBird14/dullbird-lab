package com.dullbird.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-11 17:21
 */
public class Test32_1 {
    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {

        if (Objects.isNull(root)) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pollFirst();
            result.add(pop.val);
            if (null != pop.left) {
                queue.add(pop.left);
            }
            if (null != pop.right) {
                queue.add(pop.right);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
