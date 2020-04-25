package org.dullbird.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月23日 23:50:00
 */
public class RedPackageDemo {
    public static void main(String[] args) {
        int[] integers = processPackage(50, 12);
        System.out.println(Arrays.toString(integers));
    }

    /**
     *
     * @param total 红包总金额 元
     * @param num   个数
     * @return  红包列表。精确到 角
     */
    public static int[] processPackage(int total, int num) {
        if (total < 0 || num < 0) {
            throw new IllegalArgumentException();
        }
        Random random = new Random();
        int[] redArray = new int[num];
        // 处理的情况，精确到1毛钱
        total = total * 10;
        // 红包要随机。
        for (int i = 0; i < num - 1; i++) {
            int onePackageNum = random.nextInt(total);
            redArray[i] = onePackageNum;
            total -= onePackageNum;
        }
        redArray[num - 1] = total;
        return redArray;
    }
}
