package com.dullbird.demo.offer;

import java.util.Arrays;

/**
 * @author : cys
 * date: 2021-07-04 14:56
 */
public class Test17 {

        //数字比较小的情况
//    public static void main(String[] args) {
//        Test17 test17 = new Test17();
//        int[] s = test17.printNumbers(3);
//
//        System.out.println(Arrays.toString(s));
//    }
//    public int[] printNumbers(int n) {
//        int i = 1;
//        double pow = Math.pow(10, n);
//        int[] result = new int[(int)pow-1];
//        while (i / pow != 1) {
//            result[i-1] = i;
//            i++;
//        }
//        return result;
//    }
    //todo
    private StringBuilder stringBuilder;
    private int x;
    private String[] numbers = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static void main(String[] args) {
        Test17 test17 = new Test17();
        String s = test17.printNumbers(2);
        System.out.println(s);
    }

    //大数字的解法，。就是数字不能用long表示的
    public String printNumbers(int n) {
        stringBuilder = new StringBuilder();
        this.x = n;
        dfs(0, "");
        return stringBuilder.toString();
    }

    private void dfs(int i, String pre) {
        if (i==x) {
            stringBuilder.append(",");
            return;
        }

        for (int j = 0; j < numbers.length; j++) {
            stringBuilder.append(pre + numbers[j]);
            dfs(i+1, pre + numbers[j]);
        }
    }
}
