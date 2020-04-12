package com.dullbird.demo.geek;

import java.util.Objects;

/**
 * 求数组的逆序对
 * 比如
 * {1,2,3}
 * 逆序对是0
 * {3, 2 ,1}
 *  逆序对是 3 {3,2} {3,1} {2,1}
 * @author cys
 * @date 2019-08-25 8:49 PM
 */

public class InverseSequence {
    public static void main(String[] args) {
        int[] array = {1, 1, 1};
        int i = countInverseSequences(array, 0, array.length - 1);
        System.out.println(i);

    }
    /**
     *f(n) = f(Rn) + f(Ln) + merge{Rn+Ln}
     * 分治思想，左边的逆序对 + 右边的逆序对 + 合并的左右合并的逆序对
     */
     public static int countInverseSequences(int[] array, int start, int end) {
         if (start >= end) {
             return 0;
         }

         int mid = start + (end - start)/2;
         int ri = countInverseSequences(array, start, mid);
         int li = countInverseSequences(array, mid + 1, end);
         int mergei = merge(array, start, mid, end);
         return ri + li + mergei;
     }

    private static int merge(int[] array, int start, int mid,  int end) {
        int inverseSequencesCount = 0;
        int[] newArray = new int[end - start +1];
        int i = start;
        int j = mid + 1;
        int y = 0;
        while (i <= mid
                && j <= end) {
            if (array[i] <= array[j]) {
                newArray[y++] = array[i++];
            } else {
                inverseSequencesCount += mid - i + 1;
                newArray[y++] = array[j++];
            }
        }

        while (i<= mid){
            newArray[y++] = array[i++];
        }

        while (j<= end){
            newArray[y++] = array[j++];
        }

        for (int x =0; x < array.length-1; x++) {
            array[start++] = newArray[x];
        }
        return inverseSequencesCount;
    }
}
