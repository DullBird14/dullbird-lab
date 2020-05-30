package com.dullbird.demo.geek.sort;

import java.util.Arrays;

/**
 * 选择排序。
 * 分为已排区间和未排区间
 * 每次选择未排中选择最小的。
 * 插入到已排序区间的末尾
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 23:24:00
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = ArrayUtils.createArray(30);
//        int[] array = {2, 4, 0, 2, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("current i = " + i);
            int minIndex = i;
            int j = i;
            for (; j < array.length; j++) {
                System.out.printf("index j = %d, value=%d, j +1 = %d, value=%d \n",
                        minIndex, array[minIndex], j, array[j]);
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            System.out.printf("swap %d to %d \n", i, minIndex);
            ArrayUtils.swap(array, i, minIndex);
        }

        return array;
    }

}
