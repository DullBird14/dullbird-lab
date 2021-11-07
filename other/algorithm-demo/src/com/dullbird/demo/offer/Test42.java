package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-21 13:04
 */
public class Test42 {
    int max = Integer.MIN_VALUE;
    int temp = 0;

    public int maxSubArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp < 0) {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
                continue;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Test42 test42 = new Test42();
        int i = test42.maxSubArray(new int[]{-2, -1, -5});
        System.out.println(i);
    }
}
