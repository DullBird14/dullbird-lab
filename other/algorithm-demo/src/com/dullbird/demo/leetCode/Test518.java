package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-08-28 11:58
 */
public class Test518 {
    public static void main(String[] args) {
        Test518 test518 = new Test518();
        System.out.println(test518.change(3, new int[]{1, 2}));
        System.out.println(test518.change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        //创建状态数组
        int[] dp = new int[amount + 1];
        dp[0] =1;
        //遍历可以取的钱，计算出组合
        for (int coin : coins) {
            //遍历金额,优化 i = coin
            for (int i = coin; i <= amount; i++) {
//                if (i < coin) {
//                    continue;
//                }
                //当前金额可以是前一个金额的组合数 过来的
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
