package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : cys
 * date: 2021-09-27 13:05
 */
public class Test556 {
    public static void main(String[] args) {
        Test556 test556 = new Test556();
//        System.out.println(test556.nextGreaterElement(12));
//        System.out.println(test556.nextGreaterElement(135543));
//        System.out.println(test556.nextGreaterElement(2147483476));
        System.out.println(test556.nextGreaterElement(1999999999));
    }

    public int nextGreaterElement(int n) {
        List<Long> queue = new ArrayList<>();
        long pre = -1;
        long sum = n;
        while (sum > 0) {
            long waitForCheckValue = sum % 10;
            if (waitForCheckValue < pre) {
                for (int j = 0; j < queue.size(); j++) {
                    if (queue.get(j) > waitForCheckValue) {
                        sum = sum / 10 * 10 + queue.get(j);
                        queue.set(j, waitForCheckValue);
                        break;
                    }
                }
                for (long integer : queue) {
                    sum = sum * 10 + integer;
                }
                sum = sum > Integer.MAX_VALUE ? -1 : sum;
                sum = sum < 0 ? -1 : sum;
                return (int)sum;
            } else {
                queue.add(waitForCheckValue);
                pre = waitForCheckValue;
                sum = sum / 10;
            }

        }
        return -1;
    }
}
