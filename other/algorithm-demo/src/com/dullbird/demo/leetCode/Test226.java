package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-13 23:05
 */
public class Test226 {
    public static void main(String[] args) {
        Test226 test226 = new Test226();
//        test226
    }
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode left = root.left;
        invertTree(left);
        invertTree(root.right);
        root.left = root.right;
        root.right = left;
        return root;
    }
}
