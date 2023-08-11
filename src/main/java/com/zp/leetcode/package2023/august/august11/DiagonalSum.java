package com.zp.leetcode.package2023.august.august11;

/**
 * 矩阵对角线元素的和
 */
public class DiagonalSum {

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j || i + j == n - 1){
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}
