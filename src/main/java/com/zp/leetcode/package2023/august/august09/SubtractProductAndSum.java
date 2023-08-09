package com.zp.leetcode.package2023.august.august09;

/**
 * 整数的各位积和之差
 */
public class SubtractProductAndSum {

    public static void main(String[] args) {
        SubtractProductAndSum subtractProductAndSum = new SubtractProductAndSum();
        System.out.println(subtractProductAndSum.subtractProductAndSum(4421));
    }

    public int subtractProductAndSum(int n) {
        String str = String.valueOf(n);
        Long sum0 = 1L;
        Long sum1 = 0L;
        for (int i = 0; i < str.length(); i++) {
            int value = Integer.parseInt(str.substring(i, i + 1));
            sum0 *= value;
            sum1 += value;
        }
        return (int) (sum0 - sum1);
    }

}
