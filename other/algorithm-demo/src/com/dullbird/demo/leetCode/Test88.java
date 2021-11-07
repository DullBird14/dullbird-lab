package com.dullbird.demo.leetCode;


import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-08-27 23:09
 */
public class Test88 {
    public static void main(String[] args) {
        Test88 test88 = new Test88();
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        test88.merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
//
        a = new int[]{1};
        b = new int[]{};
        test88.merge(a, 1, b, 0);
        System.out.println(Arrays.toString(a));
        a = new int[]{4, 5, 6, 0, 0, 0};
        b = new int[]{1, 2, 3};
        test88.merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0
                && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[i + j + 1] = nums2[j--];
            } else {
                nums1[i + j + 1] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[i + j + 1] = nums2[j--];
        }
    }


}
