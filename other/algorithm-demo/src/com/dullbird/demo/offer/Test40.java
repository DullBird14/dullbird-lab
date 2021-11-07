package com.dullbird.demo.offer;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-07-19 13:12
 */
public class Test40 {

    public static void main(String[] args) {
        Test40 test40 = new Test40();
//        int[] input = {0, 1, 2, 1};
//        int[] input = {2, 1, 3, 0,1,4, 2};
        int[] input = {0,0,2,3,2,1,1,2,0,4};
        int[] leastNumbers = test40.getLeastNumbers(input, 10);
        System.out.println(Arrays.toString(leastNumbers));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        int i = innerLoop(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i1 = 0; i1 < i; i1++) {
            result[i1] = arr[i1];
        }
        return result;
    }

    private int innerLoop(int[] arr, int minIndex, int maxIndex, int targetNumber) {
        int i = minIndex;
        int j = maxIndex;
        int partitionValue = arr[maxIndex];
        while (j > i) {
            while (j > i && arr[i] <= partitionValue) {
                i++;
            }
            while (j > i && arr[j] >= partitionValue) {
                j--;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        if (i == targetNumber) {
            return i;
        } else if (i < targetNumber) {
            return innerLoop(arr, i + 1, maxIndex, targetNumber);
        } else {
            return innerLoop(arr, minIndex, i - 1, targetNumber);
        }
    }

}
