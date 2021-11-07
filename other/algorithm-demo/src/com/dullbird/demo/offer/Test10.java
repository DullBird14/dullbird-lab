package com.dullbird.demo.offer;

public class Test10 {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i1=1,i2=2,temp=0;
        for (int i = 2; i < n; i++) {
            temp = (i1 + i2)%1000000007;
            i1 = i2;
            i2 = temp;
        }
        return temp;
    }
}