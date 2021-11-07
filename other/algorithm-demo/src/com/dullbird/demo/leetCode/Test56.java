package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : cys
 * date: 2021-08-14 17:22
 */
public class Test56 {
    public static void main(String[] args) {
        Test56 test56 = new Test56();
//        int[][] temp = {{1, 3}, {1, 2}, {8, 10}, {15, 18}};
        int[][] temp = {{1, 3}};
        int[][] merge = test56.merge(temp);
        Arrays.stream(merge).forEach(it -> System.out.println(Arrays.toString(it)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            int s1 = o1[0];
            int e1 = o1[1];
            int s2 = o2[0];
            int e2 = o2[1];
            if (s1 > s2) {
                return 1;
            }
            if (s1 == s2 && e1 > e2) {
                return 1;
            }
            if (s1 == s2 && e1 == e2) {
                return 0;
            }
            return -1;
        });
        List<int[]> result = new ArrayList<>();
        int mergeStart = intervals[0][0];
        int mergeEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int is = intervals[i][0];
            int ie = intervals[i][1];
            if (is <= mergeEnd && mergeStart <= ie) {
                mergeStart = Math.min(mergeStart, is);
                mergeEnd = Math.max(mergeEnd, ie);
            } else {
                result.add(new int[]{mergeStart, mergeEnd});
                mergeStart = is;
                mergeEnd = ie;
            }
        }
        result.add(new int[]{mergeStart, mergeEnd});
        int[][] resultArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
