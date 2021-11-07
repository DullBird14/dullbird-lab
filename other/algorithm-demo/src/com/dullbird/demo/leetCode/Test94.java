package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-28 23:41
 */
public class Test94 {
    public static void main(String[] args) {
        Test94 test94 = new Test94();
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
        System.out.println(test94.inorderTraversal(a_1));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        innerInorderTraversal(root, list);
        return list;
    }

    private void innerInorderTraversal(TreeNode root, List<Integer> list) {
        if (Objects.isNull(root)) {
            return ;
        }
        innerInorderTraversal(root.left, list);
        list.add(root.val);
        innerInorderTraversal(root.right, list);
    }
}
