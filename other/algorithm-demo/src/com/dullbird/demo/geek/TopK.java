package com.dullbird.demo.geek;

import java.util.Arrays;
import java.util.Objects;

/**
 *leetcode 215
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author cys
 * @date 2019-08-18 9:50 PM
 */

public class TopK {
    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int[] nums = new int[]{7,6,5,4,3,2,1};
//        int kthLargest = findKthLargest(nums, 4, 0, nums.length - 1);
//        System.out.println(kthLargest);
//        int[] heap = createHeap(nums);
//        System.out.println(Arrays.toString(heap));
        System.out.println(heapTopK(nums, 5));
    }

    public static int heapTopK(int[] nums, int k){
        int[] heapArray = createHeap(nums);
        int count = heapArray.length - 1;
        for (int i = 1; i < k; i++) {
            System.out.println(heapArray[1]);
            heapArray[1] = heapArray[count];
            count--;
            heapify(heapArray, count, 1);
        }
        return heapArray[1];
    }

    public static void heapify(int[] nums, int count, int index){
        while (true){
            int maxPos = index;
            if (index * 2<= count && nums[index] <nums[index * 2]) {
                maxPos = index * 2;
            }
            if (index * 2 +1 <= count && nums[maxPos] <nums[index * 2 +1 ]) {
                maxPos = index * 2 +1 ;
            }
            if (maxPos == index) {
                return;
            }
            int temp = nums[index];
            nums[index] = nums[maxPos];
            nums[maxPos] = temp;
            index = maxPos;
        }
    }

    public static int[] createHeap(int[] nums) {
        int[] maxHeapArray = new int[nums.length + 1];
        //哨兵
        maxHeapArray[0] = Integer.MAX_VALUE;
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            int y = j;
            int thisNumber = nums[i];
            maxHeapArray[j++] = thisNumber;
            while (y/2 >=0) {
                int numUpThisNumber = maxHeapArray[y/2];
                if (numUpThisNumber < thisNumber) {
                    maxHeapArray[y] = numUpThisNumber;
                    maxHeapArray[y/2] = thisNumber;
                    y = y/2;
                } else {
                    break;
                }
            }
        }
        return maxHeapArray;
    }
    /**
     * 方法一,快排思维。
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k, int s, int e) {
        int partition = partition(nums, s, e);
        int differ = nums.length - partition;
        if (differ == k) {
            return nums[partition];
        } else if (differ > k) {
            return findKthLargest(nums, k, partition + 1, e);
        } else {
            return findKthLargest(nums, k, s, partition - 1);
        }
    }

    private static int partition(int[] nums, int s, int e) {
        int chooseNum = nums[e];
        int i=s,j=s;
        for (;j < e; j++) {
            if (nums[j] < chooseNum) {
                int temp = nums[i];
                nums[i++] =nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i];
        nums[i] = chooseNum;
        nums[e] = temp;
        return i;
    }
}
