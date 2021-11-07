package com.dullbird.demo.leetCode;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-09-14 13:19
 */
public class Test64 {
    public static void main(String[] args) {
        Test64 test64 = new Test64();
        System.out.println(test64.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(test64.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }));
    }

    public int minPathSum(int[][] grid) {
        int[][] sumGrid = new int[grid.length][grid[0].length];
        for (int[] ints : sumGrid) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        sumGrid[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                inner(sumGrid, grid, i, j);
            }
        }
        return sumGrid[grid.length-1][grid[0].length-1];
    }

    private void inner(int[][] sumGrid, int[][] grid, int i, int j) {
        if (i - 1 >= 0) {
            sumGrid[i][j] = Math.min(sumGrid[i - 1][j] + grid[i][j], sumGrid[i][j]);
        }
        if (j - 1 >= 0) {
            sumGrid[i][j] = Math.min(sumGrid[i][j - 1] + grid[i][j], sumGrid[i][j]);
        }
    }

}
