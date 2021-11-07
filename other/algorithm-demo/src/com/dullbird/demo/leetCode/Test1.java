package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-10 00:17
 */
public class Test1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int leftValue = target - nums[i];
            Integer leftIndex = map.get(leftValue);
            if (Objects.nonNull(leftIndex)
                    && leftIndex != i) {
                return new int[]{i, leftIndex};
            }
        }
        return new int[]{};
    }
}
