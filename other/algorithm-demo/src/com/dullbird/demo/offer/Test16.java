package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-04 14:45
 */
public class Test16 {
    public static void main(String[] args) {
        Test16 a = new Test16();
        System.out.println(a.myPow(2.10000, 3));
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        //如果指数是负数
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n = n >> 1;
        }

        return result;
    }
}
