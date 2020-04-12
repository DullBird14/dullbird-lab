package com.dullbird.demo.chapter.one;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author cys
 * @date 2018-09-06 下午12:53
 */

public class Main {


    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);//生成Scanner对象
        Integer a = sc.nextInt(); //读下一个整型字符串
        sc.nextLine();
        Integer[] b=new Integer[a];
        String numbers = sc.nextLine();
        String[] split = numbers.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            b[i] = Integer.parseInt(split[i] );
        }

        System.out.println(new Main().wayFour(b));

    }

    /**
     * d
     * @param array
     * @return
     */
    public int wayFour(Integer[] array) {
        int maxSum = 0, temSum = 0, tempSstartIndex=0;
//        Integer startIndex =0 , endIndex = null ;
        for (int i = 0; i < array.length; i++) {
            temSum += array[i];
            if (temSum < 0 ) {
                temSum = 0;
//                tempSstartIndex = i+1;
                continue;
            }
            if (temSum > maxSum) {
                maxSum = temSum;
//                endIndex = i;
//                startIndex = tempSstartIndex;
            }
        }
//        System.out.print(maxSum + " " +startIndex+" " + endIndex);
        return maxSum;
    }



    /**
     * 分而治之，递归的思想，实现nlogn
     * @return
     */
    public int wayThree(List<Integer> list, int left, int right) {
        int rightMax, leftMax, middleLeftMax = 0, middleRightMax = 0;

        if (left == right) {
            if (list.get(left) > 0) {
                return list.get(left);
            } else {
                return 0;
            }
        }
        int center = (left + right) >> 1;
        leftMax = wayThree(list, left, center);
        rightMax = wayThree(list, center + 1 , right);

        int temLeftMiddleSum = 0;
        for (int i = center; i >= left; i--) {
            temLeftMiddleSum += list.get(i);
            if (temLeftMiddleSum > middleLeftMax) {
                middleLeftMax = temLeftMiddleSum;
            }
        }

        int temRightMiddleSum = 0;
        for (int i = center + 1 ; i <= right; i++) {
            temRightMiddleSum += list.get(i);
            if (temRightMiddleSum > middleRightMax) {
                middleRightMax = temRightMiddleSum;
            }
        }

        return getMaxFromThree(leftMax, rightMax, middleLeftMax + middleRightMax);
    }

    private int getMaxFromThree(int a, int b, int c){
        return a > b ? a >c ? a : c : b > c ? b : c;
    }

    /**
     * i是子列的左标，j是子列的右标,
     * 复杂度n^3
     * @param array
     * @return
     */
    public int wayOne(Integer[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j ; k++) {
                    thisSum += array[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }

        }
        return maxSum;
    }

    /**
     * i是子列的左标，j是子列的右标
     * 复杂度 n^2
     * @param array
     * @return
     */
    public int wayTwo(Integer[] array) {
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            int thisSum = 0;
            for (int j = i; j < array.length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }
}
