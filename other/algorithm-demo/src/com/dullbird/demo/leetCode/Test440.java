package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-15 13:30
 */
public class Test440 {
    public static void main(String[] args) {
        Test440 test440 = new Test440();
//        System.out.println(test440.findKthNumber(25, 3));
//        System.out.println(test440.findKthNumber(200, 3));
        System.out.println(test440.findKthNumber(200, 12));
    }

    public int findKthNumber(int n, int k) {
        int i = 1;
        k = k - 1;
        while (k > 0) {
            int nodes = getNodes(n, i);
            if (k >= nodes) {
                i++;
                k -= nodes;
            } else {
                i *= 10;
                k--;
            }
        }
        return i;
    }

    /**
     * 获取当前current下面所有小于n的数量
     *
     * @param n
     * @param current
     * @return
     */
    private int getNodes(int n, long current) {
        long next = current + 1;
        long total = 0L;
        while (current <= n) {
            total += Math.min(n - current + 1, next - current);

            next *= 10;
            current *= 10;
        }
        return (int) total;
    }
}
