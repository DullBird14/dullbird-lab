package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-08 15:28
 */
public class Test42 {
    public static void main(String[] args) {
        Test42 test42 = new Test42();
        System.out.println(
                test42.trap(new int[]{0, 1, 0, 2}));

        System.out.println(
                test42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3}));
    }

    public int trap(int[] height) {
        int total = 0;
        int[] rightMaxHeight = new int[height.length];
        rightMaxHeight[height.length - 1] = height[height.length - 1];
        //从尾遍历到头。计算右边的最大值
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
        }
        int leftMax = height[0];
        //从左到右，计算最高值和左边最高值
        for (int i = 1; i < height.length - 1; i++) {
            int rightMax = rightMaxHeight[i];
            total += Math.max(0, Math.min(rightMax, leftMax) - height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }
        return total;
    }

    private int speedLow(int[] height) {
        //简单。但是效率没有这么高 (n * height)的时间复杂度 空间复杂度是 Max(height)
        Map<Integer, Integer> indexAndHeightMap = new HashMap<>();
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int heightValue = height[i];
            for (int i1 = 1; i1 <= heightValue; i1++) {
                Integer integer = indexAndHeightMap.get(i1);
                if (Objects.nonNull(integer)) {
                    total += i - integer - 1;
                }
                indexAndHeightMap.put(i1, i);
            }
        }
        return total;
    }
}
