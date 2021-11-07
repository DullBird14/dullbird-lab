package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-08 11:23
 */
public class Test33 {
    public static void main(String[] args) {
        Test33 test33 = new Test33();
//        System.out.println(test33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(test33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(test33.search(new int[]{1}, 0));
//        System.out.println(test33.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
//        System.out.println(test33.search(new int[]{5,1,2,3,4}, 1));
        System.out.println(test33.search(new int[]{1,3,5}, 1));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                //那么处于前半区
                if (target >= nums[0] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    // 包括 target在前半区，target大于nums[mid]
                    // 包括 target在旋转去，target小于nums[mid]
                    start = mid + 1;
                }
            } else {
                // 处于旋转区域
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
