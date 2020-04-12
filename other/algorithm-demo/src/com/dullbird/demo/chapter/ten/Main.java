package com.dullbird.demo.chapter.ten;

/**
 * @author cys
 * @date 2018-11-18 下午7:02
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * 10-排序4 统计工龄 （20 分）
 * 给定公司N名员工的工龄，要求按工龄增序输出每个工龄段有多少员工。
 *
 * 输入格式:
 * 输入首先给出正整数N（≤10
 * ​5
 * ​​ ），即员工总人数；随后给出N个整数，即每个员工的工龄，范围在[0, 50]。
 *
 * 输出格式:
 * 按工龄的递增顺序输出每个工龄的员工个数，格式为：“工龄:人数”。每项占一行。如果人数为0则不输出该项。
 *
 * 输入样例:
 * 8
 * 10 2 0 5 7 2 5 2
 * 输出样例:
 * 0:1
 * 2:3
 * 5:2
 * 7:1
 * 10:1
 */
//8
//10 2 0 5 7 2 5 2
public class Main {
    private static final int radix = 10;
    private static final int maxDigit = 2;
    //基数排序
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String numbers = in.nextLine();
        String[] stringArrays = numbers.split(" ");
        int[] originalArray = new int[n];
        for (int i = 0; i < n; i++) {
            originalArray[i] = Integer.valueOf(stringArrays[i]);
        }
//        System.out.println(Arrays.toString(originalArray));
//        基数排序
//        int[] ints = tryLSDRadixSort(originalArray, originalArray.length);
//        System.out.println(Arrays.toString(ints));

        tryLSDRadixSortForTest(originalArray, originalArray.length);

    }
    private static void tryLSDRadixSortForTest(int[] array, int number) {
        //初始化数组
        List<Integer>[] bucket = new LinkedList[50];
        List<Integer> temp = new LinkedList();
        //初始化到一个链表中
        for (int item : array) {
            temp.add(item);
        }

        for (int itemNumber : temp) {
            int digit = getDigit(itemNumber, 1, 50);
            List<Integer> integers = bucket[digit];
            if (Objects.isNull(integers)) {
                bucket[digit] = new LinkedList(){{
                    this.add(itemNumber);
                }};
            } else {
                integers.add(itemNumber);
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            if (Objects.nonNull(bucket[i])) {
                System.out.println(i + ":" + bucket[i].size());
            }
        }

    }


    private static int[] tryLSDRadixSort(int[] array, int number) {
        //初始化数组
        List<Integer>[] bucket = new LinkedList[radix];
        List<Integer> temp = new LinkedList();
        //初始化到一个链表中
        for (int item : array) {
            temp.add(item);
        }

        for (int d = 1; d <= maxDigit; d++) {
            for (int itemNumber : temp) {
                int digit = getDigit(itemNumber, d, radix);
                List<Integer> integers = bucket[digit];
                if (Objects.isNull(integers)) {
                    bucket[digit] = new LinkedList(){{
                        this.add(itemNumber);
                    }};
                } else {
                    integers.add(itemNumber);
                }
            }

            temp = new LinkedList<>();
            for (int i = 0; i < bucket.length; i++) {
                if (Objects.nonNull(bucket[i])) {
                    temp.addAll(bucket[i]);
                    bucket[i] = null;
                }
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }
        return array;
    }

    private static int getDigit(int itemNumber, int digit, int radix){
        int d = -1;
        for (int i = 0; i < digit; i++) {
            d = itemNumber % radix;
            itemNumber = itemNumber/radix;
        }
        return d;
    }
}
