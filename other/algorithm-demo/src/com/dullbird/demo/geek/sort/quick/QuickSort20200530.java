package com.dullbird.demo.geek.sort.quick;

import com.dullbird.demo.geek.sort.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * 快排
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 23:24:00
 */
public class QuickSort20200530 {
    public static void main(String[] args) {
        int[] array = ArrayUtils.createArray(30);
//        int[] array = {0, 2, 0};
//        int[] array = {3, 0, 1, 0, 4};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        System.out.printf("input start=%d, end =%d, index=%d, array=%s\n",
                start, end, index, Arrays.toString(array));
        sort(array, 0, index - 1);
        sort(array, index + 1, end);
    }

    /**
     * 不是从数组的前后遍历。仅从头开始遍历
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int chooseValue = array[end];
        int i, j;
        for (i = start, j = i; j < end; j++) {
            // 相等交换可以保证稳定性
            if (array[i] <= chooseValue) {
                ArrayUtils.swap(array, i, j);
                i++;
            }
        }
        ArrayUtils.swap(array, i, end);
        return i;
    }

}
