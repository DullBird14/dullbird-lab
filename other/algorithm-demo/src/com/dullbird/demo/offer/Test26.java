package com.dullbird.demo.offer;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-04 21:20
 */
public class Test26 {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (Objects.isNull(B)
                || Objects.isNull(A)) {
            return false;
        }

        if (compare(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B)) {
            return true;
        }
        return false;
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (Objects.isNull(b)
                && Objects.isNull(a)) {
            return true;
        }

        if (Objects.isNull(a)
                || a.val !=b.val) {
            return false;
        }

        return compare(a.left, b.left)
                && compare(a.right, b.right);
    }
}
