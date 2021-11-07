package com.dullbird.demo.offer;

import java.util.Objects;

public class Test12 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfsSearch(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsSearch(char[][] board, int i,
                             int j, String word, int index) {
        // i,j不越界
        if (i < 0 || j < 0 || i >= board.length
                || j >= board[0].length
                || word.charAt(index) != board[i][j]
                || board[i][j] == '/') {
            return false;
        }
        if (index + 1 > word.length()) {
            return true;
        }
        //本轮递归标记已经搜索。并且结束的时候会清除。很妙
        board[i][j] = '/';
        //上搜索
        if (dfsSearch(board, i - 1, j, word, index + 1)
                //下搜索
                || dfsSearch(board, i + 1, j, word, index + 1)
                //左搜索
                || dfsSearch(board, i, j - 1, word, index + 1)
                //右搜索
                || dfsSearch(board, i, j + 1, word, index + 1)) {
            return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}