package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-03 23:45
 */
public class Test13 {

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        int i = test13.movingCount(20, 20, 9);
        for (int x = 0; x < visited.length; x++) {
            for (int y = 0; y < visited[x].length; y++) {
                if (visited[x][y]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println(i);
    }
    static boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, k, m, n, 0, 0);
    }

    private int dfs(int i, int j, int k, int m, int n, int iTotal, int jTotal) {
        if (i >= m || j >= n
                || (iTotal + jTotal) > k
                || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;

//        System.out.printf("i=%s, j=%s, iTotal=%s, jTotal=%s\n", i, j, iTotal, jTotal);
        //往下移动
        return 1 +
                //往下移动
                dfs(i + 1, j, k, m, n,
                        (i + 1) % 10 == 0 ? iTotal - 8 : iTotal + 1
                        , jTotal) +
                //往右移动
                dfs(i, j + 1, k, m, n, iTotal,
                        (j + 1) % 10 == 0 ? jTotal - 8 : jTotal + 1);
    }


}
