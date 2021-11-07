package com.dullbird.demo.offer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author : cys
 * date: 2021-07-25 23:03
 */
public class Test31 {
    public static void main(String[] args) {
        Test31 test31 = new Test31();
        boolean b = test31.validateStackSequences(new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 2, 1});
        System.out.println(b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> tempQueue = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length
                || j < popped.length) {
            int popValue = popped[j];
            Integer integer = tempQueue.peekLast();
            if (Objects.equals(integer, popValue)) {
                tempQueue.pollLast();
                j++;
                continue;
            }
            while (i < pushed.length
                    && !Objects.equals(popValue, tempQueue.peekLast())) {
                tempQueue.offer(pushed[i++]);
            }

            if (!Objects.equals(tempQueue.removeLast(), popValue)) {
                return false;
            }
            j++;
        }
        return true;
    }
}
