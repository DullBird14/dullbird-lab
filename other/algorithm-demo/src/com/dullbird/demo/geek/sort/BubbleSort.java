package com.dullbird.demo.geek.sort;

import java.util.Arrays;
import java.util.Random;


/**
 * 冒泡排序
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 22:48:00
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = ArrayUtils.createArray(30);
//        int[] array = {2, 0, 0};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }


    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

}
