package com.dullbird.demo.chapter.nine.one;

/**
 * @author cys
 * @date 2018-11-03 下午9:49
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 09-排序1 排序 （25 分）
 * 给定N个（长整型范围内的）整数，要求输出从小到大排序后的结果。
 *
 * 本题旨在测试各种不同的排序算法在各种数据情况下的表现。各组测试数据特点如下：
 *
 * 数据1：只有1个元素；
 * 数据2：11个不相同的整数，测试基本正确性；
 * 数据3：103个随机整数；
 * 数据4：104个随机整数；
 * 数据5：105个随机整数；
 * 数据6：105个顺序整数；
 * 数据7：105个逆序整数；
 * 数据8：105个基本有序的整数；
 * 数据9：105个随机正整数，每个数字不超过1000。
 * 输入格式:
 * 输入第一行给出正整数N（≤10
 * ​5
 * ​​ ），随后一行给出N个（长整型范围内的）整数，其间以空格分隔。
 *
 * 输出格式:
 * 在一行中输出从小到大排序后的结果，数字间以1个空格分隔，行末不得有多余空格。
 *
 * 输入样例:
 * 输出样例:
 * -20 -17 -5 0 4 8 10 29 43 50 981
 */
//11
//4 981 10 -17 0 -20 29 50 8 43 -5
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String numbers = in.nextLine();
        String[] stringArrays = numbers.split(" ");
        long[] originalArray = new long[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = Long.valueOf(stringArrays[i]);
        }
//        System.out.println(Arrays.toString(originalArray));
//        long[] result = shellSort(originalArray);
        long[] result = quickSort(originalArray);
//        System.out.println(Arrays.toString(result).replaceAll("\\[|\\]", ""));
        for (int i = 0; i < result.length -1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(result[result.length -1]);

    }

    /**
     * 冒泡排序
     * @param arrays
     * @return
     */
    private static long[] bubbleSort(long[] arrays) {
        int length = arrays.length;
        for (int i = length - 1; i >= 0; i--) {
            boolean ifDoSomeThing = false;
            for (int j = 0; j < i ; j++) {
                long jValue = arrays[j];
                long nextValue = arrays[j + 1];
                if (jValue > nextValue) {
                    arrays[j] = nextValue;
                    arrays[j + 1] = jValue;
                    ifDoSomeThing = true;
                }
            }
            if (!ifDoSomeThing) {
                break;
            }
        }
        return arrays;
    }

    /**
     * 插入排序
     * @param arrays
     * @return
     */
    private static long[] insertSort(long[] arrays) {
        int length = arrays.length;
        int j ;
        for (int i = 1; i < length; i++) {
            long temp = arrays[i];
            for (j = i; j >0 && arrays[j - 1] > temp ; j--) {
                arrays[j] = arrays[j-1];
            }
            arrays[j] = temp;
        }
        return arrays;
    }

    /**
     * 希尔排序
     * @param arrays
     * @return
     */
    private static long[] shellSort(long[] arrays) {
        ArrayList<Integer> sedgewickValue = new ArrayList<Integer>();
        sedgewickValue.add(0);
        sedgewickValue.add(1);
        int length = arrays.length;
        //初始化 sedgewickValue  4^i - 3 * 2^i +1
        for (int i = 0,sedValue = 0; sedValue < length; i++) {
            sedValue = new Double(Math.pow(4, i) - 3 * Math.pow(2, i) +1).intValue();
            if (sedValue > 1
                    && sedValue < length) {
                sedgewickValue.add(sedValue);
            }
        }
        // 遍历 sedgewickValue
        for (int i = sedgewickValue.size() - 1; i > 0; i--) {
            Integer sed = sedgewickValue.get(i);
            int y;
            for (int x = sed; x < length; x++) {
                long temp = arrays[x];
                // 其中是 >= sed
                for (y = x; y >= sed && arrays[y - sed] > temp ; y-= sed) {
                    arrays[y] = arrays[y-sed];
                }
                arrays[y] = temp;
            }
        }
        return arrays;
    }

    public static long[] quickSort(long[] arrays){
        fastSort(arrays, 0, arrays.length -1);
        return arrays;
    }
    /**
     * 快速排序
     */
    private static void fastSort(long[] arrays, int left, int right){
        if (left >= right) {
            return;
        }

        long pivot = medianThree(arrays, left, right);
        int s = left;
        int e = right - 1;
        while (s < e) {
            while (arrays[++s] < pivot) {

            }
            while (arrays[--e] > pivot) {

            }
            if (s < e) {
                swap(arrays, s, e);
            }
        }
        swap(arrays, s, right-1);
        fastSort(arrays, left, s - 1);
        fastSort(arrays, s + 1, right);
    }

    /**
     * 获取中位数，并且调整位置。
     * @param arrays
     * @param left
     * @param right
     * @return
     */
    private static long medianThree(long[] arrays, int left, int right) {
        long value = 0;
        int middle = (left + right) / 2;
        long leftValue = arrays[left];
        long rightValue = arrays[right];
        long medianValue = arrays[middle];
        //如果左边比中间大，那么把左边和中间交换
        if (arrays[left] > arrays[middle]) {
            swap(arrays, left, middle);
        }
        if (arrays[left] > arrays[right]) {
            swap(arrays, left, right);
        }
        if (arrays[right] < arrays[middle]) {
            swap(arrays, middle, right);
        }
        //把中位数，藏到right -1
        swap(arrays, middle, right-1);
        return arrays[right -1];
    }
    private static void swap(long[] arrays, int from, int to){
        long fromValue = arrays[from];
        arrays[from] = arrays[to];
        arrays[to] = fromValue;

    }
//    private static getSedgewickValue()
}
