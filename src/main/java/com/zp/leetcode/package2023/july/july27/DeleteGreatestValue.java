package com.zp.leetcode.package2023.july.july27;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/7/27 10:22
 * 删除每行中的最大值
 **/
public class DeleteGreatestValue {

    public static void main(String[] args) {

    }

    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int i = 0; i < m; i++) {
                mx = Math.max(mx, grid[i][j]);
            }
            res += mx;
        }
        return res;
    }
}
