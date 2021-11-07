package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-31 11:05
 */
public class Test33 {
    public static void main(String[] args) {
        Test33 test33 = new Test33();
        boolean b = test33.verifyPostorder(new int[]{1,3,2,6,5});
        System.out.println(b);
    }
    public boolean verifyPostorder(int[] postorder) {
        return innerVerifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean innerVerifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = postorder[end];
        int p = start;
        while (postorder[p] < rootVal) {
            p++;
        }
        while (postorder[p] > rootVal) {
            p++;
        }
        return p == end
                && innerVerifyPostorder(postorder, start, p - 1)
                && innerVerifyPostorder(postorder, p, end - 1);
    }
}
