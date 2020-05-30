package com.dullbird.demo.geek.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cys
 * @date 2019-08-01 8:46 PM
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[500];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500);
        }
//        int[] array = {0,3,7,1,2,5,9,4,8,6};

        System.out.println(Arrays.toString(array));
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println("size:" + array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param array
     * @param start
     * @param end
     */
    public void quickSort(int[] array, int start, int end){
        if (start >= end) {
            return;
        }

        int mid = partition(array, start, end);
        quickSort(array, start, mid - 1);
        quickSort(array, mid + 1, end);
    }

    public int partition(int[] array, int start, int end) {
        //todo 此处可以优化中间点的取值，防止快排退化
        int midValue = array[end];
        // i 是小于mid的数组指针，j是大于的数组指针
        int i, j;
        for ( i = start, j = i; j < end; j++) {
            //todo 此处等于要不要交换，为什么？
            if (array[j] <= midValue) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i ++;
            }
        }

        array[end] = array[i];
        array[i] = midValue;
        return i;
    }
}
