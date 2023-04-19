package com.zp.leetcode.package2023.april.april19;

/**
 * @author zhengpeng
 * @date 2023/4/19 2:20 下午
 * 分割数组以得到最大和
 **/
public class MaxSumAfterPartitioning {

    public static void main(String[] args) {
        int[] array = new int[]{1,15,7,9,2,5,10};
        int k = 3;
        MaxSumAfterPartitioning maxSumAfterPartitioning = new MaxSumAfterPartitioning();
        System.out.println(maxSumAfterPartitioning.maxSumAfterPartitioning(array,k));

    }



    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return  d[n];
    }
}
