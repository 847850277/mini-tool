package com.zp.leetcode.package2023.july.july28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/7/28 15:46
 * 并行课程III
 **/
public class MinimumTime {

    public int minimumTime(int n, int[][] relations, int[] time) {
        int mx = 0;
        List<Integer>[] pre = new List[n + 1];
        for (int i = 0; i <= n ; i++) {
            pre[i] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            int x = relation[0],y = relation[1];
            pre[y].add(x);
        }
        Map<Integer,Integer> memo = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            mx = Math.max(mx,dp(i,time,pre,memo));
        }
        return mx;
    }

    private int dp(int i, int[] time, List<Integer>[] pre, Map<Integer, Integer> memo) {
        if (!memo.containsKey(i)) {
            int cur = 0;
            for (int p : pre[i]) {
                cur = Math.max(cur, dp(p, time, pre, memo));
            }
            cur += time[i - 1];
            memo.put(i, cur);
        }
        return memo.get(i);
    }
}
