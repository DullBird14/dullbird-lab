package com.dullbird.demo.offer;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-07-04 16:27
 */
public class Test21 {
    public static void main(String[] args) {
        Test21 test21 =new Test21();
        System.out.println(Arrays.toString(test21.exchange(new int[]{1,2,3,4})));
    }

    public int[] exchange(int[] nums) {
        int firstIndex = 0;
        int tailIndex = nums.length -1;
        int temp ;
        while (firstIndex < nums.length
                && firstIndex <= tailIndex) {
            if ((nums[firstIndex] & 1) == 1) {
                firstIndex++;
            } else if ((nums[firstIndex] & 1) == 0) {
                temp = nums[firstIndex];
                nums[firstIndex] = nums[tailIndex];
                nums[tailIndex--] = temp;
            }
        }
        return nums;
    }
}
