package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-09-01 23:48
 */
public class Test78 {
    public static void main(String[] args) {
        Test78 test78 = new Test78();
        System.out.println(test78.subsets(new int[]{1}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        result.add(new ArrayList<>(tempResult));
        innerSubsets(nums, 0, result, tempResult);
        return result;
    }

    private void innerSubsets(int[] nums, int i, List<List<Integer>> result, List<Integer> tempResult) {
        if (nums.length == i) {
            return;
        }
        //选择放入
        tempResult.add(nums[i]);
        result.add(new ArrayList<>(tempResult));
        innerSubsets(nums, i + 1, result, tempResult);
        tempResult.remove(tempResult.size()-1);
        //不选择放入
        innerSubsets(nums, i + 1, result, tempResult);
    }
}
