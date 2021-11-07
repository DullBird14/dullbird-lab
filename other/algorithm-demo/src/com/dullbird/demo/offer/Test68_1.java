package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-28 23:48
 */
public class Test68_1 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val == p.val
                    || root.val == q.val) {
                return root;
            }
            if ((root.val > p.val && root.val < q.val)
                    || (root.val < p.val && root.val > q.val)) {
                return root;
            }
            if (root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

}
