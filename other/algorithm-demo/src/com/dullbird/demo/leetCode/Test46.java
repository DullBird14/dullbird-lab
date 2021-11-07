package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-16 12:56
 */
public class Test46 {
    public static void main(String[] args) {
        Test46 test46 = new Test46();
        List<List<Integer>> permute = test46.permute(new int[]{1, 2,3});
        System.out.println(permute);
    }
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        inner(nums, 0, new ArrayList<>(nums.length));
        return result;
    }
    public void inner(int[] nums, int j, List<Integer> tempResult) {
        if (nums.length == j) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            tempResult.add(j, nums[j]);
            inner(nums, j+1, tempResult);
            swap(nums, j, i);
            tempResult.remove(j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
