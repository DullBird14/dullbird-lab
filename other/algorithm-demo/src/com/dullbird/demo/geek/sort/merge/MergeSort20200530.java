package com.dullbird.demo.geek.sort.merge;

import com.dullbird.demo.geek.sort.ArrayUtils;

import java.util.Arrays;

/**
 * 快排
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 23:24:00
 */
public class MergeSort20200530 {
    public static void main(String[] args) {
        int[] array = ArrayUtils.createArray(50);
//        int[] array = {0, 2, 0};
//        int[] array = {3, 0, 1, 0, 4};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));

//        testMerge();start=3, end =4, mid=0
    }

    private static void testMerge() {
        int[] array = {1,6,2,5,8};
        merge(array, 0, 4, 1);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end - start) / 2 + start;
        System.out.printf("input start=%d, end =%d, mid=%d, array=%s\n",
                start, end, mid, Arrays.toString(array));
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, end, mid);
    }

    public static void merge(int[] array, int start, int end, int mid) {
        int startOne = start;
        int startMid = mid + 1;
        int i = 0;
        int[] tempArray = new int[end - start + 1];
        //合并
        while (startOne <= mid
                && startMid <= end) {
            if (array[startOne] <= array[startMid]) {
                tempArray[i++] = array[startOne++];
            } else {
                tempArray[i++] = array[startMid++];
            }
        }
        // 如果前半数组剩余
        while (startOne <= mid) {
            tempArray[i++] = array[startOne++];
        }
        // 如果后半数据剩余
        while (startMid <= end) {
            tempArray[i++] = array[startMid++];
        }
        // 拷贝到原来的数组
        for (int x = 0; x < tempArray.length; x++) {
            array[start++] = tempArray[x];
        }
    }

}
