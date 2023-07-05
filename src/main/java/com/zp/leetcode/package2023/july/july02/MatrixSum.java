package com.zp.leetcode.package2023.july.july02;

/**
 * @author zhengpeng
 * @date 2023/7/4 09:39
 * 矩阵中的和
 **/
public class MatrixSum {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        MatrixSum matrixSum = new MatrixSum();
        int i = matrixSum.matrixSum(matrix);
        System.out.println(i);

    }




    public int matrixSum(int[][] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currMax = Integer.MIN_VALUE;
            int[] num = nums[i];
            for (int j = 0; j < num.length; j++) {
                currMax = Math.max(currMax,nums[i][j]);
            }
            sum += currMax;
        }
        return sum;
    }

}
