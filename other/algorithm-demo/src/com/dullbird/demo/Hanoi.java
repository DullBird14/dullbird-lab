package com.dullbird.demo;

import java.util.Objects;

/**
 * @author cys
 * 汉诺塔的移动，有X,Y,Z三根柱子，X上有n个盘子，从小到大，从上往下排列。
 *
 * @date 2018-08-23 下午8:41
 */
public class Hanoi {
    /**
     * 分析问题:
     * 如果能把最底下n盘上面的n-1个盘子移动到Y柱上，那么就可以把n移动到z。
     * 这时候如果把n-1底盘上面的n-2个移动到X柱子，那么n-2就可以移动到z。依此类推
     */
    public static void main(String args[]) {
        moveHanoi(3, "x", "y", "z");
    }

    /**
     * 移动层级为n的汉诺塔，从x移动到z。
     */
    private static void moveHanoi(Integer n, String x, String y, String z) {
        if (Objects.equals(n, 1)) {
            move(n, x, z);
        } else {
            moveHanoi(n-1, x, z, y);
            System.out.println("");
            move(n, x, z);
            moveHanoi(n-1, y, x, z);
        }
    }

    /**
     * 移动方法
     * @param n
     * @param x
     * @param z
     */
    private static void move(Integer n, String x, String z) {
        System.out.print("移动编号" + n + String.format(" 从 %s -> %s！", x, z));
    }
}
