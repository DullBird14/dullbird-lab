package com.dullbird.demo.geek.sort;

import java.util.Random;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 22:48:00
 */
public class ArrayUtils {
    /**
     * 创建一个随机的数组
     * @param length
     * @return
     */
    public static int[] createArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    /**
     * 换地交换数字
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        if ( i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
