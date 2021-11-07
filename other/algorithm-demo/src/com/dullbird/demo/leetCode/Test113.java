package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-04 11:39
 */
public class Test113 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(-2);
        TreeNode a_2 = new TreeNode(1);
        TreeNode a_3 = new TreeNode(-3);
//        a_1.left = a_2;
        a_1.left = a_3;
        Test113 test113 = new Test113();
        System.out.println(test113.pathSum(a_1, -5));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> totalResult = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        innerPathSum(root, targetSum, totalResult, tempList);
        return totalResult;
    }

    private void innerPathSum(TreeNode root, int targetSum, List<List<Integer>> totalResult, List<Integer> tempList) {
        if (root == null) {
            return;
        }

        int tempValue = targetSum - root.val;
        tempList.add(root.val);
        if (tempValue == 0
                && Objects.isNull(root.left)
                && Objects.isNull(root.right) ) {
            totalResult.add(new ArrayList(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }

        innerPathSum(root.left, tempValue, totalResult, tempList);
        innerPathSum(root.right, tempValue, totalResult, tempList);
        tempList.remove(tempList.size() - 1);
    }
}
