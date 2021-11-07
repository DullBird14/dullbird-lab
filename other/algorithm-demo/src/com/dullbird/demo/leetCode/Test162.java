package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-22 21:11
 */
public class Test162 {
    public static void main(String[] args) {
        Test162 test162 = new Test162();
        System.out.println(test162.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(test162.findPeakElement(new int[]{-2147483648}));
        System.out.println(test162.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start)/2 + start;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }
        }

        return start;
    }

//    private int innerFindPeakElement(int[] nums, int start, int end) {
//
//        return 0;
//    }
}
