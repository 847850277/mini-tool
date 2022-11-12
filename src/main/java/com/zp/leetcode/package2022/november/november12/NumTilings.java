package com.zp.leetcode.package2022.november.november12;

/**
 * @author zhengpeng
 * @date 2022/11/12 5:20 下午
 * 多米诺和拖米诺平铺
 **/
public class NumTilings {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        NumTilings num = new NumTilings();
        int n = 3;
        System.out.println(num.numTilings(n));
    }


    public int numTilings(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }
}
