package com.zp.leetcode.package2023.march.march22;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/3/22 9:09 上午
 * 无矛盾的最佳球队
 **/
public class BestTeamScore {

    public static void main(String[] args) {
        //int[] scores = new int[]{1,3,5,10,15};
        //int[] ages = new int[]{1,2,3,4,5};

        int[] scores = new int[]{4,5,6,5};
        int[] ages = new int[]{2,1,2,1};

        BestTeamScore bestScore = new BestTeamScore();
        System.out.println(bestScore.bestTeamScore(scores,ages));



    }


    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        //排序
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                //满足什么条件？
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
