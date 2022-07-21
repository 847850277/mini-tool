package com.zp.leetcode.package_2022.july.july21;

/**
 * @author zhengpeng
 * @date 2022/6/14 9:14 上午
 * 背包问题
 **/
public class Knapsack {

    int knapsack(int W, int N, int[] wt, int[] val) {
        // base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]
                    );
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int[] wt = new int[]{2,1,3};
        int[] val = new int[]{4,2,3};
        System.out.println(knapsack.knapsack(4,3,wt,val));



    }
}
