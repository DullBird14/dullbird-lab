package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-04 15:20
 */
public class Test128 {
    public static void main(String[] args) {
        Test128 test128 = new Test128();
        System.out.println(test128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }
        int max = 0;
        int tempNum = 0;
        for (Integer currentNum : map.keySet()) {
            Integer preNum = map.get(currentNum - 1);
            if (Objects.nonNull(preNum)) {
                continue;
            }

            while (true) {
                Integer value = map.get(currentNum++);
                if (Objects.isNull(value)) {
                    break;
                }
                tempNum++;
            }
            max = Math.max(tempNum, max);
            tempNum = 0;
        }
        return max;
    }
}
