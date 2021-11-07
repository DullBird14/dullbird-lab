package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-25 00:33
 */
public class Test221 {
    public static void main(String[] args) {
        Test221 test221 = new Test221();
//        char[][] test = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };
        char[][] test = {
                {'0'}
        };
        int i = test221.maximalSquare(test);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(parseToInt(matrix[i][j]), max);
                if (i - 1 < 0 || j - 1 < 0) {
                    continue;
                }
                int i1 = parseToInt(matrix[i - 1][j - 1]);
                int i2 = parseToInt(matrix[i - 1][j]);
                int i3 = parseToInt(matrix[i][j - 1]);
                int i4 = parseToInt(matrix[i][j]);
                if (i1 == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
                    continue;
                }
                int min = Math.min(Math.min(i1, i2), i3);
                if (min + 1 > max) {
                    max = min + 1;
                }
                matrix[i][j] = (char) ((min + 1) + '0');
            }
        }

        return max * max;
    }

    private int parseToInt(char a) {
        return a - (int) '0';
    }
}
