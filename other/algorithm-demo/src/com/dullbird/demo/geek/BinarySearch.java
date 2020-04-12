package com.dullbird.demo.geek;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cys
 * @date 2019-08-04 9:43 PM
 */

public class BinarySearch {

    public static void main(String[] args) {
//        int[] array = new int[500];
//        Random random = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(500);
//        }
//
//        System.out.println(Arrays.toString(array));
//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));
//        BinarySearch binarySearch = new BinarySearch();
//        System.out.println("===========================");
//        System.out.println(binarySearch.binarySearch(array, 45));
        BinarySearch binarySearch = new BinarySearch();
        int[] array2 = {1, 2, 2, 2, 2, 2, 5};
//        System.out.println(binarySearch.searchFirstValueEquals(array2, 2));
        System.out.println(binarySearch.searchValueEqualsMore(array2, 5));
//        System.out.println(binarySearch.binarySearch(new int[1], 45));


    }

    public int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        //todo 如果low = high，比如{1,2,3}寻找3的时候，
        while (low <= high) {
            // todo 注意点二，防止low high过大溢出 int类型
            int mid = low + ((high - low) >>1);
            int midValue = array[mid];
            if (value == midValue){
                return mid;
            } else if (value > midValue) {
                //todo 必须是mid +- 1,不能是mid，比如单数组。如果是low=0,high=1,如果是low=mid的话死循环
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分变形1：找到第一个等于给定值的元素
     * 变形2: 查找最后一个等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int searchFirstValueEquals(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        //todo 如果low = high，比如{1,2,3}寻找3的时候，
        while (low <= high) {
            // todo 注意点二，防止low high过大溢出 int类型
            int mid = low + ((high - low) >>1);
            int midValue = array[mid];
            if (value == midValue){
                /**
                 * 查找第一个等于给定值的元素
                 */
//                if (mid == 0 || array[mid - 1] != midValue) {
//                    return mid;
//                }
//                high = high - 1;
                /**
                 * 查找最后一个等于给定值的元素
                 */
                if (mid == array.length - 1 || array[mid + 1] != midValue) {
                    return mid;
                }
                low = low + 1;
            } else if (value > midValue) {
                //todo 必须是mid +- 1,不能是mid，比如单数组。如果是low=0,high=1,如果是low=mid的话死循环
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 二分变形3：找到第一个大于等于给定值的元素
     * 变形4: 查找最后一个小于等于给定值的元素,同3,不再写了
     * @param array
     * @param value
     * @return
     */
    public int searchValueEqualsMore(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        //todo 如果low = high，比如{1,2,3}寻找3的时候，
        while (low <= high) {
            // todo 注意点二，防止low high过大溢出 int类型
            int mid = low + ((high - low) >>1);
            int midValue = array[mid];
            /**
             * 二分变形3：找到第一个大于等于给定值的元素
             */
            if (midValue >= value) {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                }
                high = high - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}























