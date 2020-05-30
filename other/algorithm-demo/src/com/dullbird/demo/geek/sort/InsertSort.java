package com.dullbird.demo.geek.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 分已排序区间和未排序区间。
 * 选择未排序区间的第一个
 * 在已排序区间中查找插入位置
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 23:24:00
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = ArrayUtils.createArray(30);
//        int[] array = {1, 0, 2};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        // 当前遍历的未插入的位置
        int i = 1;
        while (i < array.length) {
            // 待插入的值
            int value = array[i];
            int x = i - 1;
            for (; x >= 0; x--) {
                // 从已处理节点的末尾往前遍历
                if (array[x] > value) {
                    array[x + 1] = array[x];
                } else {
                    break;
                }
            }
            array[x + 1] = value;
            i++;
        }

        return array;
    }

    /**
     * 插入的位置是x的后面，x->j的要移动一位，i是值的位置
     *
     * @param array
     * @param x
     * @param i
     */
    private static void add(int[] array, int x, int i, int j) {
        int temp = array[i];
        while (j > x) {
            array[j + 1] = array[j];
            j--;
        }
        array[x + 1] = temp;
    }
}
