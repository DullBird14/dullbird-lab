package com.dullbird.demo.chapter.one;

/**
 * @author cys
 * @date 2018-09-03 下午7:55
 */

public class OnePointerThree {
    /**
     * 计算多项式
     * @param args
     */
    public static void main(String args[]) {
        OnePointerThree onePointerThree = new OnePointerThree();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000 ; i++) {
            onePointerThree.caculateValueOne(10000, 5.0);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        for (int i = 0; i < 10000; i++) {
            onePointerThree.caculateValueTwo(10000, 5.0);
        }
        long finishTime = System.nanoTime();
        System.out.println(finishTime - endTime);
    }

    /**
     * 初始化常数
     * @param n
     * @return
     */
    private double[] initParam(int n){
        double[] params = new double[n];
        for (int i = 0; i < n ; i++) {
            params[i] = (1*1.0)/(i+1.0);
        }
        return params;
    }

    public double caculateValueOne(int n, double x){
        double sum = 1;
        double[] params = initParam(n);
        /**
         * 复杂度 1+2+3+...+n
         */
        for (int i = 1; i <= n ; i++) {
//            System.out.print(Math.pow(x, i) * params[i-1] + " + ");
            sum += Math.pow(x, i) * params[i-1];
        }
//        System.out.println();
        return sum;
    }

    public double caculateValueTwo(int n, double x){
        double sum = 0;
        double[] params = initParam(n);
//        System.out.println(Arrays.toString(params));
        for (int i = n; i >= 1 ; i--) {
//            System.out.println(params[i-1] + "+" + x * sum );
            sum =  params[i-1] + x * sum;
//            System.out.println(sum );
        }
        sum += 1;
        return sum;
    }

}
