package com.zp.leetcode.package_2022.june.june01;

/**
 * @author zhengpeng
 * @date 2022/6/1 1:37 下午
 **/
public class TrailingZeroes {
    public long trailingZeroes(int n) {
        long sum = 1;
        for (int i = 1; i <= n; i++){
            sum *= i ;
        }
        return sum;
    }

    public int trailingZeroes1(int n) {
        int cnt = 0;
        for (long num = 5; n / num > 0; num *= 5) {
            cnt += n / num;
        }
        return cnt;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(10));
        System.out.println(trailingZeroes.trailingZeroes(15));
        System.out.println(trailingZeroes.trailingZeroes1(10));
        System.out.println(trailingZeroes.trailingZeroes1(15));
        //System.out.println(trailingZeroes.trailingZeroes(5));
        //System.out.println(trailingZeroes.trailingZeroes(3));


    }
}
