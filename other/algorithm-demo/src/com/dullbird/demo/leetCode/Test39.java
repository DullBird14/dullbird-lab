package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-28 21:54
 */
public class Test39 {
    public static void main(String[] args) {
        Test39 test39 = new Test39();
        System.out.println(test39.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(test39.combinationSum(new int[]{1, 2}, 3));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //不能用dp。需要具体的组合。而不是数量
//        int[] dp = new int[target + 1];
//        //为0的情况只有一种就是不选任何金额
//        dp[0] = 1;
//        for (int candidate : candidates) {
//            for (int i = candidate; i <= target; i++) {
//                dp[i] += dp[i - candidate];
//            }
//        }
//        return dp[target];
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        innerCombinationSum(candidates, target, 0, temp, result);
        return result;
    }

    private void innerCombinationSum(int[] candidates, int target, int j, List<Integer> temp, List<List<Integer>> result) {
        for (int i = j; i < candidates.length; i++) {
            int value = target - candidates[i];
            if (value < 0) {
                return;
            }
            temp.add(candidates[i]);
            if (value == 0) {
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
            innerCombinationSum(candidates, value, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

}
