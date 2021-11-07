package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-05 20:36
 */
public class Test28 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 终止条件，1。如果左右都是null，那么返回true，说明上面的都是对称的
        // 2. 如果有一个null，一个不是null，false，说明不堆成。
        // 3. 当前值不相等，false
        // 4. 如果值相等。继续往下递归
        if (null == left
                && null == right) {
            return true;
        }
        if ((null == left && null != right)
                || (null != left && null == right)
                || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
