package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-13 23:12
 */
public class Test230 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(1);
        TreeNode a_2 = new TreeNode(2);
        TreeNode a_3 = new TreeNode(3);
        TreeNode a_4 = new TreeNode(4);
        a_3.left = a_1;
        a_1.right = a_2;
        a_3.right = a_4;
        Test230 test230 = new Test230();
        test230.kthSmallest(a_3, 1);
    }

    private int result = 0;
    private int i = 0;

    public int kthSmallest(TreeNode root, int k) {
        inner(root, k);
        return result;
    }

    private int inner(TreeNode root, int k) {
        if (Objects.isNull(root)) {
            return 0;
        }
        inner(root.left, k);
        if (++i == k) {
            result = root.val;
            return 0;
        }
        inner(root.right, k);
        return 0;
    }
}
