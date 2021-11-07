package com.dullbird.demo.offer;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-07-05 20:49
 */
public class Test29 {
    public static void main(String[] args) {
        Test29 test29 = new Test29();
        int[] ints = test29.spiralOrder(new int[][]{{2,5},{8,4},{0,-1}});
        System.out.println(Arrays.toString(ints));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix
                || matrix.length == 0) {
            return new int[0];
        }
        int top = 0, down = matrix.length - 1,
                left = 0, right = matrix[0].length - 1;
        int x = 0, y = 0, index = 0;
        int[] result = new int[matrix[0].length * matrix.length];
        result[index++] = matrix[x][y];
        while (true) {
            while (y < right) {
                //向右
                result[index++] = matrix[x][++y];
            }
            if (++top > down) {
                break;
            }
            while (x < down) {
                //向下
                result[index++] = matrix[++x][y];
            }
            if (--right < left) {
                break;
            }
            while (y > left) {
                result[index++] = matrix[x][--y];
            }
            if (--down < top ) {
                break;
            }
            while (x > top) {
                result[index++] = matrix[--x][y];
            }
            if (++left > right) {
                break;
            }
        }

        return result;
    }
}
