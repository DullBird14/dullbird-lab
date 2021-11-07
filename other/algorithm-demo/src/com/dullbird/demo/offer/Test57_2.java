package com.dullbird.demo.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : cys
 * date: 2021-07-26 23:41
 */
public class Test57_2 {
    public static void main(String[] args) {
        Test57_2 test57_2 = new Test57_2();
        int[][] continuousSequence = test57_2.findContinuousSequence(9);
        System.out.println(Arrays.toString(continuousSequence));
    }

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < target; i++) {
            sum += i;
            tempResult.add(i);
            while (sum > target
                    && tempResult.size() > 1) {
                Integer remove = tempResult.remove(0);
                sum -= remove;
            }
            if (sum == target) {
                result.add(new ArrayList<>(tempResult));
            }
            if (tempResult.size() < 1) {
                break;
            }
        }
        int[][] arrayResult = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> integers = result.get(i);
            int[] ints = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                ints[j] = integers.get(j);
            }
            arrayResult[i] = ints;
        }
        return arrayResult;
    }
}
