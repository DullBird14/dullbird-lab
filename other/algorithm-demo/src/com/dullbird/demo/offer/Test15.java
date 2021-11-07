package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-04 14:14
 */
public class Test15 {
    public static void main(String[] args) {
        Test15 a = new Test15();
        int i = a.hammingWeight(-3);
        System.out.println(i);
    }
    public int hammingWeight(int n) {
        int result = 0;
        while (n!=0) {
            if ((n&1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }
}
