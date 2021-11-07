package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-09 12:50
 */
public class Test41 {
    public static void main(String[] args) {
        Test41 test41 = new Test41();
//        System.out.println(test41
//                .firstMissingPositive(new int[]{1, 2, 0}));

//        System.out.println(test41
//                .firstMissingPositive(new int[]{3,4,-1,1}));

        System.out.println(test41
                .firstMissingPositive(new int[]{1, 1}));

//        System.out.println(test41
//                .firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public int firstMissingPositive(int[] nums) {
        int s = 1;
        int e = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value < s || value > e) {
                //替换成n+1
                nums[i] = e + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (value <= e
                    && nums[value - 1] > 0) {
                nums[value - 1] = -nums[value - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return e + 1;
    }
}
