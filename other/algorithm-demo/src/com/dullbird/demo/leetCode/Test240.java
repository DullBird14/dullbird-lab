package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-14 23:52
 */
public class Test240 {
    public static void main(String[] args) {
        Test240 test240 = new Test240();
        System.out.println(test240.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length
                && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }

        return false;
    }
}
