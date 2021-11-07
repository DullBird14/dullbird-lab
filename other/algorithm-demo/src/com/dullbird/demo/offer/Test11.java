package com.dullbird.demo.offer;

import java.util.Objects;

public class Test11 {
    //todo
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5};
        Test11 test11 = new Test11();
        System.out.println(test11.minArray(a));
    }


    public int minArray(int[] numbers) {
        if (Objects.isNull(numbers)
                || numbers.length == 0) {
            return -1;
        }

        int start = 0;
        int end = numbers.length - 1;
        int mid;
        while (true) {
            if (end <= start) {
                break;
            }
            mid = (end - start) / 2 + start;
            System.out.printf("start=%s, end =%s, mid=%s\n", start, end, mid);
            if (numbers[end] < numbers[mid]) {
                //这里可以+1
                start = mid + 1;
                continue;
            }
            if (numbers[end] > numbers[mid]) {
                end = mid;
                continue;
            }
            if (numbers[end] == numbers[mid]) {
                end = --end;
            }
        }
        return numbers[end];
    }
}