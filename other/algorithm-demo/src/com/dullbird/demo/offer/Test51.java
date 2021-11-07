package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-25 12:07
 */
public class Test51 {
    public static void main(String[] args) {
        Test51 test51 = new Test51();
//        int combine = test51.combine(new int[]{1, 3, 0, 5}, 0, 1, 2, 3);
//        System.out.println(combine);
        int i = test51.reversePairs(new int[]{7,5,6,4});
        System.out.println(i);
    }

    public int reversePairs(int[] nums) {
        return innerReversePairs(nums, 0, nums.length - 1);
    }

    private int innerReversePairs(int[] nums, int i, int j) {
        if (i == j
                || nums.length == 0) {
            return 0;
        }
        int mid = (j - i) / 2 + i;
        int i1 = innerReversePairs(nums, i, mid);
        int i2 = innerReversePairs(nums, mid + 1, j);
        return combine(nums, i, mid, mid + 1, j) + i1 + i2;
    }

    /**
     * 合并两个有序的数组
     *
     * @param nums
     * @param startA
     * @param endA
     * @param startB
     * @param endB
     * @return
     */
    public int combine(int[] nums, int startA, int endA,
                       int startB, int endB) {
        int aStart = startA;
        int bStart = startB;
        int[] tempResult = new int[endB - startA + 1];
        int i = 0;
        int resultNum = 0;
        while (aStart <= endA
                && bStart <= endB) {
            if (nums[aStart] <= nums[bStart]) {
                tempResult[i++] = nums[aStart++];
            } else {
                resultNum += endA - aStart + 1;
                tempResult[i++] = nums[bStart++];
            }
        }
        while (aStart <= endA) {
            tempResult[i++] = nums[aStart++];
        }
        while (bStart <= endB) {
            tempResult[i++] = nums[bStart++];
        }
        for (int value : tempResult) {
            nums[startA++] = value;
        }
        return resultNum;
    }
}
