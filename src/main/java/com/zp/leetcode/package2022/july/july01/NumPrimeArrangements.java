package com.zp.leetcode.package2022.july.july01;

/**
 * @author zhengpeng
 * @date 2022/7/1 2:29 下午
 * 质数排列
 **/
public class NumPrimeArrangements {

    public static void main(String[] args) {
        NumPrimeArrangements n = new NumPrimeArrangements();
        //System.out.println(n.numPrimeArrangements(4));
        System.out.println(n.numPrimeArrangements(10));
    }


    static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        int numPrimes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                numPrimes++;
            }
        }
        return (int) (factorial(numPrimes) * factorial(n - numPrimes) % MOD);
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }



}
