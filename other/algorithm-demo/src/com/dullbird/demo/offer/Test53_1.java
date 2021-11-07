package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-23 13:16
 */
public class Test53_1 {
    public static void main(String[] args) {
        Test53_1 test53 = new Test53_1();
//        int targetIndex = test53.search(new int[]{5,7,7,8,8,10}, 9);
//        System.out.println(targetIndex);
        int targetIndex1 = test53.findTargetIndex(new int[]{5,7,7,8,8,10}, 9);
        System.out.println(targetIndex1);
    }

    public int search(int[] nums, int target) {
        return findTargetIndex(nums, target) - findTargetIndex(nums, target - 1);
    }

    /**
     * 找到距离target最近的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetIndex(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int mid = 0;
        while (startIndex <= endIndex) {
            mid = (endIndex - startIndex) / 2 + startIndex;
            if (nums[mid] > target) {
                endIndex = mid - 1;
            } else if (nums[mid] <= target) {
                startIndex = mid + 1;
            }
        }
        return startIndex ;
    }
}
