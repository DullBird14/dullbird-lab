package com.dullbird.demo.geek.sort.merge;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 * mergeSort(array, 0, n) = merge(mergeSort(array, 0, q), mergeSort(array, q+1, n))
 * @author cys
 * @date 2019-07-30 10:48 PM
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[500];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500);
        }
        System.out.println(Arrays.toString(array));
        MergeSort mergeSort = new MergeSort();
        //bug代码
//        int[] ints = mergeSort.mergeSort(array, 0, array.length);
//        System.out.println("size:" + ints.length);
//        System.out.println(Arrays.toString(ints));

        mergeSort.voidMergeSort(array, 0, array.length - 1);
        System.out.println("size:" + array.length);

        System.out.println(Arrays.toString(array));
    }

    public void voidMergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return ;
        }

        int mid = start + (end - start)/2;
        voidMergeSort(array, start, mid);
        voidMergeSort(array, mid + 1, end);
        merge(array, start, mid, mid + 1, end);
    }
    /**
     * 需要注意到底是小于等于还是等于。还未确定
     * @param array
     * @param aStart
     * @param aEnd
     * @param bStart
     * @param bEnd
     */
    //todo 哨兵省略算法的方式
    public void merge(int[] array, int aStart, int aEnd, int bStart, int bEnd) {
        int[] result = new int[bEnd - aStart + 1];
        int i = aStart;
        int j = bStart;
        int y = 0;
        while(i <= aEnd
                && j <= bEnd) {
            if (array[i] <= array[j]) {
                result[y++] = array[i++];
            } else {
                result[y++] = array[j++];
            }
        }

        // 如果数组A剩余
        for (; i <= aEnd; i++, y++) {
            result[y] = array[i];
        }
        // 如果数组B剩余
        for (; j <= bEnd; j++, y++) {
            result[y] = array[j];
        }

        //把result[y] copy 到aStart~bEnd
        for (int k = 0; k < result.length ; k++) {
            array[aStart++] = result[k];
        }
    }

    //============================下面的代码有个致命的bug=======================================
    public int[] mergeSort(int[] array, int start, int end) {
        // 存在bug.如果是[0]进来无限死循环
        if (start >= end) {
            return array;
        }
        int mid = start + (end - start)/2;
        int[] startArray = Arrays.copyOfRange(array, start, mid);
        int[] endArray = Arrays.copyOfRange(array, mid, end);
        int[] nextStartArray = mergeSort(startArray, 0, startArray.length);
        int[] nextEndArray = mergeSort(endArray, 0, endArray.length);
        return merge(nextStartArray, nextEndArray);
    }

    /**
     * 将两个有序数组合并成一个大的有序数组
     * @param arrayA
     * @param arrayB
     * @return
     */
    public int[] merge(int[] arrayA, int[] arrayB) {
        int[] result = new int[arrayA.length + arrayB.length];
        int i=0;
        int j=0;
        while (i < arrayA.length
                && j < arrayB.length ) {
            if (arrayA[i] <= arrayB[j]) {
                result[i + j] = arrayA[i];
                i++;
            } else {
                result[i + j] = arrayB[j];
                j++;
            }
        }
        //如果数组A剩余
        for (; i < arrayA.length; i++) {
            result[i + j] = arrayA[i];
        }
        //如果数组B剩余
        for (; j < arrayB.length; j++) {
            result[i + j] = arrayB[j];
        }
        return result;
    }
}
