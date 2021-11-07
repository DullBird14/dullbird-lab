package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-08-05 00:28
 */
public class Test31 {
    public static void main(String[] args) {
        Test31 test31 = new Test31();
        int[] ints = {1, 3, 2};
        test31.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int j = nums.length - 2;
        while (j >= 0) {
            if (nums[j] < nums[j + 1]) {
                int i = nums.length - 1;
                while (nums[i] <= nums[j]) {
                    i--;
                }
                swap(nums, i, j);
                Arrays.sort(nums, j + 1, nums.length);
                return;
            }
            j--;
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
