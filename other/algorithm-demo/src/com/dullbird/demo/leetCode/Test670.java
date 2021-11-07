package com.dullbird.demo.leetCode;

import java.util.HashMap;

/**
 * @author : cys
 * date: 2021-09-26 22:53
 */
public class Test670 {
    public static void main(String[] args) {
        Test670 test670 = new Test670();
//        System.out.println(test670.maximumSwap(2736));
//        System.out.println(test670.maximumSwap(9973));
//        System.out.println(test670.maximumSwap(98368));
        System.out.println(test670.maximumSwap(1993));
    }

    public int maximumSwap(int num) {
        int tempValue = num;
        int max = 0;
        int i = 0;
        HashMap<Integer, Integer> indexAndNumMap = new HashMap<>();
        HashMap<Integer, Integer> originIndexAndNumMap = new HashMap<>();
        while (num != 0) {
            int temp = num % 10;
            max = Math.max(temp, max);
            num = num / 10;
            originIndexAndNumMap.put(i, temp);
            indexAndNumMap.put(i++, max);
        }
        i--;
        int k = i;
        int changeMinValue = 0;
        int changeMaxValue = 0;
        while (i >= 0) {
            Integer originalValue = originIndexAndNumMap.get(i);
            Integer current = indexAndNumMap.get(i);
            if (current > originalValue) {
                originIndexAndNumMap.put(i, current);
                changeMinValue = originalValue;
                changeMaxValue = current;
                break;
            }
            i--;
        }
        for (int i1 = 0; i1 < i; i1++) {
            Integer integer = originIndexAndNumMap.get(i1);
            if (integer == changeMaxValue) {
                originIndexAndNumMap.put(i1, changeMinValue);
                break;
            }
        }
        if (i < 0) {
            return tempValue;
        }
        int total = 0;
        while (k >= 0) {
            Integer current = originIndexAndNumMap.get(k);
            total = total * 10 + current;
            k--;
        }
        return total;
    }
}
