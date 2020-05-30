package com.dullbird.demo.geek;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月29日 23:08:00
 */
public class XORswap {
    public static void main(String[] args) {
//        normalTest();
        theSameTest();
    }
    private static void theSameTest() {
        int a = 99; //00000000 00000000 00000000 01100011
        int b = 99; //00000000 00000000 00000000 01100011
        //获取a和b的差异的特征
        a = a ^ b;  //00000000 00000000 00000000 00000000
        System.out.println(a);
        //通过差异特征a，把b中b的特异点清除，添加a的特异
        b = a ^ b;  //00000000 00000000 00000000 01100011
        System.out.println(b);
        //通过差异特征a，把a(此时b的值为原来的a=100)中a的特异点清除，添加b(原来a=99)的特异
        a = a ^ b;  //00000000 00000000 00000000 01100011
        System.out.println(a);
    }
    private static void normalTest() {
        int a = 100;//00000000 00000000 00000000 01100100
        int b = 99; //00000000 00000000 00000000 01100011
        //获取a和b的差异的特征
        a = a ^ b;  //00000000 00000000 00000000 00000111
        System.out.println(a);
        //通过差异特征a，把b中b的特异点清除，添加a的特异
        b = a ^ b;  //00000000 00000000 00000000 01100100
        System.out.println(b);
        //通过差异特征a，把a(此时b的值为原来的a=100)中a的特异点清除，添加b(原来a=99)的特异
        a = a ^ b;  //00000000 00000000 00000000 01100011
        System.out.println(a);
    }
}
