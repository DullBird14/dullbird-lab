package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-26 23:32
 */
public class Test57_1 {
    public int[] twoSum(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int sum;
        while (min < max) {
            sum = nums[min] + nums[max];
            if (sum > target) {
                max--;
            } else if (sum < target) {
                min++;
            } else {
                return new int[]{nums[min], nums[max]};
            }
        }
        return new int[]{};
    }
}
