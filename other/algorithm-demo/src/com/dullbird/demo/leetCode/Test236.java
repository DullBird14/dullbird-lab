package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-08 11:07
 */
public class Test236 {
    public static void main(String[] args) {

    }

    private TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inner(root, p, q);
        return ancestor;
    }

    private boolean inner(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = inner(root.left, p, q);
        boolean right = inner(root.right, p, q);
        if (left && right) {
            ancestor = root;
            return true;
        }
        boolean current = root == p
                || root == q;
        if (current && (left || right)) {
            ancestor = root;
            return true;
        }
        return current || left || right;
    }
}
