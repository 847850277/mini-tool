package com.zp.leetcode.package2022.december.december02;

/**
 * @author zhengpeng
 * @date 2022/12/2 10:38 上午
 * 移动所有球到每个盒子所需的最小操作数
 **/
public class MinOperations {

    public static void main(String[] args) {
        String box = "001";
        MinOperations m = new MinOperations();
        int[] ints = m.minOperations(box);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }




    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sm = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    sm += Math.abs(j - i);
                }
            }
            res[i] = sm;
        }
        return res;
    }
}
