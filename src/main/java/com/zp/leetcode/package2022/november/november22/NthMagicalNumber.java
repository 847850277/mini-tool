package com.zp.leetcode.package2022.november.november22;

/**
 * @author zhengpeng
 * @date 2022/11/22 9:24 上午
 * 第N个神奇的数字
 **/
public class NthMagicalNumber {



    public static void main(String[] args) {

        NthMagicalNumber n = new NthMagicalNumber();
        System.out.println(n.nthMagicalNumber(6,2,3));
    }

    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


}
