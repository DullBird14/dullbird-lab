package com.dullbird.demo.chapter.two;

/**
 * @author cys
 * @date 2018-09-10 下午1:07
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;

/**
 * 02-线性结构2 一元多项式的乘法与加法运算 （20 分）
 * 设计函数分别求两个一元多项式的乘积与和。
 *
 * 输入格式:
 * 输入分2行，每行分别先给出多项式非零项的个数，再以指数递降方式输入一个多项式非零项系数和指数（绝对值均为不超过1000的整数）。数字间以空格分隔。
 *
 * 输出格式:
 * 输出分2行，分别以指数递降方式输出乘积多项式以及和多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。零多项式应输出0 0。
 *
 * 输入样例:
 * 4 3 4 -5 2  6 1  -2 0             3 5 20  -7 4  3 1
 *4 3 4 -5 2  6 1  -2 0             3 5 20  -7 4  0 0
 * 输出样例:
 * 15 24 -25 22 30 21 -10 20 -21 8 35 6 -33 5 14 4 -15 3 18 2 -6 1
 * 5 20 -4 4 -5 2 9 1 -2 0
 */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        x[] arrayOne = getXArrays(sc);
        x[] arrayTwo = getXArrays(sc);
        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));

//        Arrays.sort(arrayOne, Comparator.comparingInt(x::getIndex));
//        Arrays.sort(arrayTwo, Comparator.comparingInt(x::getIndex));
//        Arrays.sort(arrayOne, (o1, o2) -> o2.getIndex() - o1.getIndex());

        //相乘
        System.out.println(multiply(arrayOne, arrayTwo).toString().replaceAll("\\[|\\]|,", ""));
        //相加
        System.out.println(add(arrayOne, arrayTwo).toString().replaceAll("\\[|\\]|,", ""));

    }
    //3 4   | -5 2  | 6 1   | -2 0
    //5 20  | -7 4  | 3 1
    private static List<x> multiply(x[] arrayOne, x[] arrayTwo){
        LinkedList<x> result = new LinkedList<>();
        if (Objects.isNull(arrayOne)
                || Objects.isNull(arrayTwo)) {
            return null;
        }

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int constant = arrayOne[i].getConstant() * arrayTwo[j].getConstant();
                int index = arrayOne[i].getIndex() + arrayTwo[j].getIndex();
//                if (Objects.equals(constant, 0)) {
//                    continue;
//                }
                int location = -1;
                //情况1，-4 4  |-5 2| 9 1| -2 0    4 2
                //情况2，-4 4  |-5 2| 9 1|         4 0    -1
                //情况3，-4 4  |-5 2| 9 1| -2 0    4 5    0
                for (int t = 0; t < result.size(); t++) {
                    x temp = result.get(t);
                    if (temp.getIndex() > index) {
                        continue;
                    } else {
                        location = t;
                        break;
                    }

                }

                if (Objects.equals(location, -1)) {
                    result.addLast(new x(constant, index));
                    continue;
                }

                x x = result.get(location);
                // 如果指数相等
                if (Objects.equals(x.getIndex(), index)){
                    int sum = x.getConstant() + constant;
                    if (Objects.equals(sum, 0)) {
                        result.remove(location);
                    } else {
                        result.set(location, new x(sum, index));
                    }
                } else {
                    result.add(location, new x(constant, index));
                }
            }
        }

        return result;
    }
    /**
     * 两个一元多项式相加
     * @param arrayOne
     * @param arrayTwo
     * @return
     */
    private static List<x> add(x[] arrayOne, x[] arrayTwo) {
        List<x> result = new ArrayList<>(arrayOne.length + arrayTwo.length);
        int i = 0, j = 0;
        while (j < arrayTwo.length
                && i < arrayOne.length) {
            x one = arrayOne[i];
            x two = arrayTwo[j];
            int differ = one.getIndex() - two.getIndex();
            if (differ == 0) {
                int constant = one.getConstant() + two.getConstant();
                if (!Objects.equals(constant, 0)) {
                    result.add(new x(constant, one.getIndex()));
                }

                i++;
                j++;
            } else if(differ > 0) {
                result.add(new x(one.getConstant(), one.index));
                i++;
            } else {
                result.add(new x(two.getConstant(), two.index));
                j++;
            }
        }

        for (; i < arrayOne.length; i++) {
            result.add(arrayOne[i]);
        }

        for (; j < arrayTwo.length; j++) {
            result.add(arrayTwo[j]);
        }

        return result;
    }

    /**
     * 读取两个一元多次多项式
     * @param sc
     * @return
     */
    private static x[] getXArrays(Scanner sc) {
        int numberOne = sc.nextInt();
        int i=0;
        x[] ints = new x[numberOne];
        x x = new x();
        while( i < numberOne * 2) {
            int temp = sc.nextInt();
            if (i % 2 == 1) {
                x.setIndex(temp);
                ints[i >>1] = x;
                x = new x();
            } else {
                x.setConstant(temp);
            }
            i++;
        }
        return ints;
    }


    static class x{
        private int constant;
        private int index;

        public x() {
        }

        public x(int constant, int index) {
            this.constant = constant;
            this.index = index;
        }

        public int getConstant() {
            return constant;
        }

        public void setConstant(int constant) {
            this.constant = constant;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return constant +" " + index;
        }
    }
}
