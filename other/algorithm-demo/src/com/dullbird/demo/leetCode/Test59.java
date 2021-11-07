package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-09-22 22:37
 */
public class Test59 {
    public static void main(String[] args) {
        Test59 test59 = new Test59();
        System.out.println(Arrays.deepToString(test59.generateMatrix(1)));
    }

    public int[][] generateMatrix(int n) {
        int up = 0;
        int left = 0;
        int right = n - 1;
        int down = n - 1;
        int[][] container = new int[n][n];
        int i = 0, j = -1, value = 0;
        while (up <= down
                && left <= right) {
            while (j < right) {
                container[i][++j] = ++value;
            }
            if (++up > down) {
                break;
            }
            while (i < down) {
                container[++i][j] = ++value;
            }
            if (--right < left) {
                break;
            }
            while (j > left) {
                container[i][--j] = ++value;
            }
            if (--down < up) {
                break;
            }

            while (i > up) {
                container[--i][j] = ++value;
            }
            if (++left > right) {
                break;
            }

        }
        return container;
    }
}
