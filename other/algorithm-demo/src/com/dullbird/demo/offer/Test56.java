package com.dullbird.demo.offer;

/**
 * a ^ a = 0;
 * a ^ a ^ b = b;
 *
 * @author : cys
 * date: 2021-07-25 00:51
 */
public class Test56 {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        //假设目标数字是x,y
        for (int num : nums) {
            temp = temp ^ num;
        }
        //经过上面的操作。现在的temp = x ^ y
        //找到temp中位运算是1的位数
        int m = 1;
        while ((temp & m) == 0) {
            m = m << 1;
        }
        int x = 0,y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
