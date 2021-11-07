package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-13 00:03
 */
public class Test69 {
    public static void main(String[] args) {
        Test69 test69 = new Test69();
//        System.out.println(test69.mySqrt(8));
//        System.out.println(test69.mySqrt(4));
//        System.out.println(test69.mySqrt(5));
//        System.out.println(test69.mySqrt(9));
//        System.out.println(test69.mySqrt(11));
//        System.out.println(test69.mySqrt(1));
//        System.out.println(test69.mySqrt(6));
//        System.out.println(test69.mySqrt(2147395599));
        System.out.println(test69.mySqrt(1));
        System.out.println(test69.mySqrt(2));
        System.out.println(test69.mySqrt(3));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0;
        int r = x;
        int mid = 0;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (mid == 0) {
                l = mid +1;
                continue;
            }
            int value = x / mid;
            if (value == mid) {
                return mid;
            } else if (value < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
