package com.zp.leetcode.package2022.november.november29;

/**
 * @author zhengpeng
 * @date 2022/11/29 9:05 上午
 * 生成交替二进制最小次数
 **/
public class MinOperations {

    public static void main(String[] args) {
        MinOperations m = new MinOperations();
        //String s = "0100";
        //String s = "10";
        //String s = "1111";
        String s = "10010100";
        System.out.println(m.minOperations(s));
    }


    public int minOperations(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断是否需要交换
            char c1 = (char) ('0' + i % 2);
            if (c != c1) {
                res++;
            }
        }
        return Math.min(res, s.length() - res);
    }
}
