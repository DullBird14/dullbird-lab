package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-07 00:05
 */
public class Test70 {
    public static void main(String[] args) {
        Test70 test70 = new Test70();
//        System.out.println(test70.climbStairs(3));
//        System.out.println(test70.climbStairs(2));
        System.out.println(test70.climbStairs(45));
    }

//    public int climbStairsTwo(int n) {
//        int i1 = 1;
//        int i2 = 2;
//        for (int i = 3; i <= n; i++) {
//
//        }
//        return 0;
//    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        Integer integer = map.get(n);
        if (integer != null) {
            return integer;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, i);
        return i;
    }
}
