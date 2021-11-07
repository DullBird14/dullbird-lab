package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-14 13:08
 */
public class Test47 {
    int[][] w;
    int x;
    int y;

    public static void main(String[] args) {
//        int[][] tests = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] tests = {{0,1}, {1,0}};
//        int[][] tests = {{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3}, {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2}, {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9}, {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7}, {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8}, {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9}, {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1}, {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3}, {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3}, {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8}, {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3}, {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3}, {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3}, {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5}, {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2}, {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0}, {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0}, {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}};
        Test47 test47 = new Test47();
        System.out.println(test47.maxValue(tests));

    }

    public int maxValue(int[][] grid) {
        x = grid.length;
        y = grid[0].length;
        w = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                w[i][j] = -1;
            }
        }
        innerMove(grid, 0, 0, 0);
        return w[x - 1][y - 1];
    }

    public void innerMove(int[][] grid, int i, int j, int value) {
        int curVal = w[i][j];
        value = value + grid[i][j];
        if (curVal >= value) {
            return;
        }
        w[i][j] = value;

        //往下走
        if (i < x - 1) {
            innerMove(grid, i + 1, j, value);
        }
        //往右走
        if (j < y - 1) {
            innerMove(grid, i, j + 1, value);
        }
    }
}
