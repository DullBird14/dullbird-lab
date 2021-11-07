package com.dullbird.demo.offer;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-04 21:34
 */
public class Test27 {
    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        if (null != left || null !=right) {
            root.left = right;
            root.right = left;
        }
        return root;
    }
}
