package com.dullbird.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-12 09:53
 */
public class Test34 {
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> tempList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        innterPathSum(root, target);
        return result;
    }

    private void innterPathSum(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target = target - root.val;
        tempList.add(root.val);
        if (target == 0
                && null == root.left
                && null == root.right) {
            result.add(new ArrayList<>(tempList));
        }
        pathSum(root.left, target);
        pathSum(root.right, target);
        tempList.removeLast();
    }
}
