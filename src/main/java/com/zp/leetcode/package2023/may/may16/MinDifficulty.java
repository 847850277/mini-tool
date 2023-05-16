package com.zp.leetcode.package2023.may.may16;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/5/16 9:29 上午
 * 工作计划的最低难度
 **/
public class MinDifficulty {


    public static void main(String[] args) {
        int[] array = new int[]{6,5,4,3,2,1};
        int d = 2;
        MinDifficulty minDifficulty = new MinDifficulty();
        System.out.println(minDifficulty.minDifficulty(array,d));

    }


    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d + 1][n];
        for (int i = 0; i <= d; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        int ma = 0;
        for (int i = 0; i < n; ++i) {
            ma = Math.max(ma, jobDifficulty[i]);
            dp[0][i] = ma;
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {
                ma = 0;
                for (int k = j; k >= i; --k) {
                    ma = Math.max(ma, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], ma + dp[i - 1][k - 1]);
                }
            }
        }
        return dp[d - 1][n - 1];
    }

}
