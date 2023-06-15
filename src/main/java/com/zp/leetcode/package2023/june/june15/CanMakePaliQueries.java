package com.zp.leetcode.package2023.june.june15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2023/6/15 15:24
 * 构建回问串检测
 **/
public class CanMakePaliQueries {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] sum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i].clone();
            sum[i + 1][s.charAt(i) - 'a']++;
        }
        // 预分配空间
        List ans = new ArrayList<Boolean>(queries.length);
        for (int[] q : queries) {
            int left = q[0], right = q[1], k = q[2], m = 0;
            for (int j = 0; j < 26; j++){
                // 奇数+1，偶数+0
                m += (sum[right + 1][j] - sum[left][j]) % 2;
            }
            ans.add(m / 2 <= k);
        }
        return ans;
    }




}
