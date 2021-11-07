package com.dullbird.demo.offer;

public class Test04 {
    public static void main(String[] args) {
        int i = 3, j = 5;
        int[][] a = new int[i][j];
        System.out.println(a.length);
        System.out.println(a[0].length);

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i, j, iLength;
        j = matrix[0].length - 1;
        i = 0;
        iLength = matrix.length - 1;
        while (i <= iLength && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
                continue;
            }
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}