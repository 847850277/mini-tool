package com.zp.leetcode.package2023.march.march29;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/3/29 5:24 下午
 * 统计字典序元音字符串的数目
 **/
public class CountVowelStrings {

    public static void main(String[] args) {

    }



    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }
}
