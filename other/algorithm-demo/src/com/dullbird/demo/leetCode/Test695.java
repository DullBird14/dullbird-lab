package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-08 21:32
 */
public class Test695 {
    public static void main(String[] args) {
        Test695 test695 = new Test695();
        System.out.println(test695.maxAreaOfIsland(new int[][]{

//                {0, 1, 1, 1, 0, 0},
//                {0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 0, 1},
        }));
    }

    private int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                innerMaxAreaOfIsland(grid, i, j);
            }
        }
        return max;
    }

    private int innerMaxAreaOfIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length) {
            return 0 ;
        }
        //如果是水陆直接放回
        if (grid[i][j] == 0) {
            return 0;
        }
        //如果已经搜索过了直接返回
        if (grid[i][j] == 2) {
            return 0;
        }
        //访问过的设置成2
        grid[i][j] = 2;
        int sum = innerMaxAreaOfIsland(grid, i - 1, j)
                + innerMaxAreaOfIsland(grid, i + 1, j)
                + innerMaxAreaOfIsland(grid, i, j - 1)
                + innerMaxAreaOfIsland(grid, i, j + 1) + 1;
        max = Math.max(sum, this.max);
        return sum;
    }
}
