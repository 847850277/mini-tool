package com.zp.leetcode.package2023.march.march01;

/**
 * @author zhengpeng
 * @date 2023/3/1 9:53 上午
 * 矩阵中的局部最大值
 **/
public class LargestLocal {

    public static void main(String[] args) {

    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }

}