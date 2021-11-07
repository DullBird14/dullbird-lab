package com.dullbird.demo.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : cys
 * date: 2021-07-27 23:55
 */
public class Test61 {
    public static void main(String[] args) {
        Test61 test61 = new Test61();
        boolean straight = test61.isStraight(new int[]{11,1,0,0,0});
        System.out.println(straight);
    }
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            if (num > max) {
                max = num;
            }
            if (num < min){
                min = num;
            }
            set.add(num);
        }
        return max - min + 1 <= 5;
    }
}
