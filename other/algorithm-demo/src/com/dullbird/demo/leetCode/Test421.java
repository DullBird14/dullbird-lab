package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : cys
 * date: 2021-11-04 13:25
 */
public class Test421 {
    public static void main(String[] args) {
        Test421 test421 = new Test421();
        System.out.println(test421.findMaximumXOR(new int[]{1, 5, 4, 6}));
    }

    public int findMaximumXOR(int[] nums) {
        //利用了性质 a ^ b = sum 就有 a^sum = b;
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            //每次增加一位，
            // 1000 0000 0000 0000
            // 1100 0000 0000 0000
            // 。。。
            // 1111 1111 1111 1111
            mask = mask | 1 << i;
            Set<Integer> tempList = new HashSet<>();
            for (int num : nums) {
                // 保留 参与数字的前n位的特征
                tempList.add(num & mask);
//                System.out.println("======add========");
//                System.out.println(Integer.toBinaryString(num & mask));
//                System.out.println("=======add=======");
            }
            // 结果的前 n 位特征 + 后面的一位
            int temp = res | 1 << i;
//            System.out.println("======temp========");
//            System.out.println(Integer.toBinaryString(temp));
//            System.out.println("======temp========");
            for (Integer integer : tempList) {
                // 根据 a ^ b = sum 就有 a^sum = b; 结果是 temp，如果temp ^ 某个值存在结果，
                //那么说明一定有2个数 ^ 之后等于temp，但是不知道是哪几个数
                if (tempList.contains(temp ^ integer)) {
//                    System.out.println("======change========");
//                    System.out.println(Integer.toBinaryString(temp ^ integer));
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
