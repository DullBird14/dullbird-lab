package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-25 22:29
 */
public class Test56_2 {
    public static void main(String[] args) {
        Test56_2 test56_2 = new Test56_2();
        int i = test56_2.singleNumber(new int[]{3, 4, 3, 3});
        System.out.println(i);
    }
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < count.length; j++) {
                count[j] += nums[i] & 1;
                nums[i] = nums[i] >> 1;
            }
        }

        for (int i = 0; i < count.length; i++) {
            count[i] = count[i] % 3;
        }
        int result = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            result = result << 1;
            result = result | count[i];
        }
        return result;
    }
}
