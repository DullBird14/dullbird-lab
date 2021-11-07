package com.dullbird.demo.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-04 16:08
 */
public class Test79 {
    public static void main(String[] args) {
        Test79 test79 = new Test79();
//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        System.out.println(test79.exist(board, "ABE"));

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(test79.exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        HashMap<String, Boolean> map = new HashMap<>();
        HashSet<Character> sets = new HashSet<>();
        for (char character : chars) {
            sets.add(character);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, chars, 0, map, sets)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int number,
                        HashMap<String, Boolean> map, HashSet<Character> sets) {
        if (i < 0
                || i >= board.length
                || j < 0
                || j >= board[0].length) {
            return false;
        }
        char c = board[i][j];
        Boolean aBoolean = map.get(i + "-" + j);
        if (Objects.nonNull(aBoolean)) {
            return false;
        }
        if (!sets.contains(c)) {
            map.put(i + "-" + j, false);
            return false;
        }
        if (c != chars[number]) {
            return false;
        }
        if (chars.length == number + 1) {
            return true;
        }
        map.put(i + "-" + j, true);
        boolean mark = dfs(board, i - 1, j, chars, number + 1, map, sets)
                || dfs(board, i + 1, j, chars, number + 1, map, sets)
                || dfs(board, i, j - 1, chars, number + 1, map, sets)
                || dfs(board, i, j + 1, chars, number + 1, map, sets);
        map.remove(i + "-" + j);
        return mark;
    }
}
