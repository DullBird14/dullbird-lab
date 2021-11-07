package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-22 12:46
 */
public class Test11 {
    public static void main(String[] args) {
        Test11 test11 = new Test11();
        System.out.println(test11.maxArea(new int[]{4,3,2,1,4}));
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int tempValue = Math.min(height[i], height[j]) * (j - i);
            if (tempValue > max) {
                max = tempValue;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
