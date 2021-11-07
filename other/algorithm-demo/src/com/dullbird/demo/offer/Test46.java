package com.dullbird.demo.offer;


/**
 * @author : cys
 * date: 2021-07-31 18:08
 */
public class Test46 {
    public static void main(String[] args) {
        Test46 test46 = new Test46();
        int i = test46.translateNum(12258);
        System.out.println(i);
    }

    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        return innerTranslateNum(num);
    }

    public int innerTranslateNum(int num) {
        if (num == 0) {
            return 0;
        }
        if (num < 10) {
            return 1;
        }
        if (num <= 25) {
            return 2;
        }
        //判断是否能取2位
        int i = num % 100;
        int j = 0;
        if (i >= 10 && i <= 25) {
            j = translateNum(num / 100);
        }
        return translateNum(num / 10) + j;
    }
}
