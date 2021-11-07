package com.dullbird.demo.offer;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-28 23:59
 */
public class Test68_2 {
    public static void main(String[] args) {
        System.out.println(true ^ false ^ true);
    }

    private TreeNode targetNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        innerLowestCommonAncestor(root, p, q);
        return targetNode;
    }

    public boolean innerLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root)) {
            return false;
        }
        boolean ifInLeft = innerLowestCommonAncestor(root.left, p, q);
        boolean ifInRight = innerLowestCommonAncestor(root.right, p, q);
        boolean ifIsCurrent = root.val == p.val || root.val == q.val;
        int count = 0;
        if (ifInLeft) {
            count++;
        }
        if (ifInRight) {
            count++;
        }
        if (ifIsCurrent) {
            count++;
        }
        if (Objects.equals(count, 2)) {
            targetNode = root;
            return true;
        }
        return ifInLeft ^ ifInRight ^ ifIsCurrent;
    }
}
