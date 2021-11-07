package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-10 23:20
 */
public class Test200 {
    public static void main(String[] args) {
        Test200 test200 = new Test200();
//        char[][] chars = {
//                {'1','1','0','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','1','0'}
//        };
        char[][] chars = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'},
        };
        int i = test200.numIslands(chars);
        System.out.println(i);
    }

    private int count = 0;
    private static char searchedMark = '2';

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int dfs = dfs(grid, i, j, grid.length, grid[0].length);
                count = count + dfs;
            }
        }
        return count;
    }

    /**
     * 如果是未探索的岛屿返回 1，否则0
     *
     * @return
     */
    private int dfs(char[][] grid, int i, int j, int iLength, int jLength) {
        if (i < 0 || i >= iLength || j < 0 || j >= jLength) {
            //越界了直接返回 null
            return 0;
        }
        if (grid[i][j] == searchedMark) {
            //已经搜索过的。不是新大陆
            return 0;
        }
        if (grid[i][j] == '0') {
            //已经是海了
            return 0;
        }
        grid[i][j] = searchedMark;
        //递归设置整个岛屿
        dfs(grid, i - 1, j, iLength, jLength);
        dfs(grid, i + 1, j, iLength, jLength);
        dfs(grid, i , j - 1, iLength, jLength);
        dfs(grid, i , j + 1, iLength, jLength);
        return 1;
    }
}
