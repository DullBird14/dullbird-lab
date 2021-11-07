package com.dullbird.demo.leetCode;

import java.util.*;

/**
 * @author : cys
 * date: 2021-09-04 15:42
 */
public class Test739 {
    public static void main(String[] args) {
        Test739 test739 = new Test739();
        System.out.println(Arrays.toString(test739.dailyTemperatures(new int[]{30,60,60,90})));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Temp> queue = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            Temp lastName = queue.peekLast();
            if (Objects.isNull(lastName)
                    || temperatures[i] <= lastName.value) {
                queue.addLast(new Temp(temperatures[i], i));
                continue;
            }
            while (lastName!=null
                    && lastName.value < temperatures[i]) {
                queue.removeLast();
                result[lastName.index] = i - lastName.index;
                lastName = queue.peekLast();
            }
            queue.addLast(new Temp(temperatures[i], i));
        }
        return result;
    }
    class Temp {
        public int value ;
        public int index ;

        public Temp(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
