package com.dullbird.demo.offer;

public class One {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}
