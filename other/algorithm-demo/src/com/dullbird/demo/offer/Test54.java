package com.dullbird.demo.offer;

import com.dullbird.demo.chapter.five.Test;

/**
 * @author : cys
 * date: 2021-07-24 17:11
 */
public class Test54 {
    int result;
    int kTimes;

    public int kthLargest(TreeNode root, int k) {
        kTimes = k;
        innerKthLargest(root);
        return result;
    }

    public void innerKthLargest(TreeNode root) {
        if (root == null
                || kTimes <= 0) {
            return;
        }

        innerKthLargest(root.left);
        kTimes--;
        if (kTimes == 0){
            result = root.val;
            return;
        }
        innerKthLargest(root.right);
    }

    public static void main(String[] args) {
        Test54 test54 = new Test54();
    }
}
