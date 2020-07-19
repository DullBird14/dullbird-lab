package com.dullbird.demo.leetCode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，
 * 飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * <p>
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月13日 23:08:00
 */
public class OneZeroTwoNine {
    public static void main(String[] args) {
        OneZeroTwoNine oneZeroTwoNine = new OneZeroTwoNine();
        int[][] temp = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int i = oneZeroTwoNine.twoCitySchedCost(temp);
        System.out.println(i);
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));

        int mid = costs.length / 2;
        int total = 0;
//        for (int i = 0; i < costs.length; i++) {
//            if (i < mid) {
//                total += costs[i][0];
//            } else {
//                total += costs[i][1];
//            }
//        }
        //优化
        for (int i = 0; i < mid; i++) {
            total += costs[i][0] + costs[i + mid][1];
        }
        return total;
    }
}
