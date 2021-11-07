package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : cys
 * date: 2021-08-14 22:59
 */
public class Test300 {
    public static void main(String[] args) {
        Test300 test300 = new Test300();
        int i = test300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);

    }


    public int lengthOfLIS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int i1 = innerFindIndex(map, num);
            if (i1 == map.size()) {
                map.put(map.size(), num);
            } else {
                map.put(i1, num);
            }
        }
        return map.size();
    }

    private int innerFindIndex(Map<Integer, Integer> map, int target) {
        if (map.size() == 0) {
            return 0;
        }
        if (map.size() == 1) {
            Integer integer = map.get(0);
            if (integer >= target) {
                return 0;
            }
            return 1;
        }

        int start = 0;
        int end = map.size() - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            Integer value = map.get(mid);
            if (value == target) {
                return mid;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
