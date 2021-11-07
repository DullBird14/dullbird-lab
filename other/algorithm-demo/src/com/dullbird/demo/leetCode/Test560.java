package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-24 23:23
 */
public class Test560 {
    public static void main(String[] args) {
        Test560 test560 = new Test560();
        System.out.println(test560.subarraySum(new int[]{1,2,3}, 3));
        System.out.println(test560.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(test560.subarraySum(new int[]{-1, 1, -1, 1, 0}, 0));
        System.out.println(test560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(test560.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
//        // O(N^2)
//        //方法一，可以的优化是提前计算累加和，
//        int count = 0;
//        //外层遍历
//        for (int left = 0; left < nums.length; left++) {
//            int total = 0;
//            for (int right = left; right < nums.length; right++) {
//                total += nums[right];
//                if (total == k) {
//                    count ++;
//                }
//            }
//        }
//        //内层遍历
//        return count;
        //方法二 O(N), 其实是累计(N) - 累计(X) = k,只关注数量
        int count = 0;
        //key是累加和，count是包涵几个数
        HashMap<Integer, Integer> sumAndCountMap = new HashMap<>();
        //这个很重要。初始值
        sumAndCountMap.put(0, 1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            Integer differCount = sumAndCountMap.get(total - k);
            if (Objects.nonNull(differCount)) {
                count += differCount;
            }
            sumAndCountMap.put(total, sumAndCountMap.getOrDefault(total, 0) + 1);
        }
        return count;
    }
}
