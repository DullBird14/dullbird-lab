package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-03 12:22
 */
public class Test15 {
    public static void main(String[] args) {
        Test15 test15 = new Test15();
        List<List<Integer>> lists = test15.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = i + 1;
            int j = nums.length - 1;
            int value = nums[i];
            //去重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (value > 0) {
                //剪枝
                break;
            }
            value = -1 * value;
            while (x < j) {
                if (x > i+1 && nums[x] == nums[x - 1]) {
                    x++;
                    continue;
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                int tempValue = nums[x] + nums[j];
                if (tempValue == value) {
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[x]);
                    tempResult.add(nums[j]);
                    tempResult.add(nums[i]);
                    result.add(tempResult);
                    j--;
                } else if (tempValue > value) {
                    j--;
                } else {
                    x++;
                }
            }
        }
        return result;
    }
}
