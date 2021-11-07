package com.dullbird.demo.leetCode;


/**
 * @author : cys
 * date: 2021-08-03 10:23
 */
public class Test215 {
    public static void main(String[] args) {
        Test215 test215 = new Test215();
        int kthLargest = test215.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return innerFindKthLargest(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int innerFindKthLargest(int[] nums, int l, int r, int target) {
        int value = nums[r];
        int i = l - 1;
        for (int x = l; x < r; x++) {
            if (nums[x] <= value) {
                swap(nums, ++i, x);
            }
        }
        swap(nums, ++i , r);
        if (i+1 == target) {
            return value;
        } else if (i+1 > target) {
            return innerFindKthLargest(nums, l, i - 1, target);
        } else {
            return innerFindKthLargest(nums, i + 1, r, target);
        }
    }

    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
