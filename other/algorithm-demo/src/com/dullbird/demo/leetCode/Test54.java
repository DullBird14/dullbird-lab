package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-09 13:17
 */
public class Test54 {
    public static void main(String[] args) {
//        int[][] matrix =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix =new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix =new int[][]{{1},{2},{3},{4}};
        Test54 test54 = new Test54();
        System.out.println(test54.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        while (true) {
            while (j < right) {
                result.add(matrix[i][++j]);
            }
            j = right;
            if (++up > down) {
                break;
            }
            while (i < down) {
                result.add(matrix[++i][j]);
            }
            if (left > --right) {
                break;
            }
            i = down;
            while (j > left) {
                result.add(matrix[i][--j]);
            }
            j = left;
            if (up > --down) {
                break;
            }
            while (i > up) {
                result.add(matrix[--i][j]);
            }
            if (--left > right) {
                break;
            }
        }

        return result;
    }
}
