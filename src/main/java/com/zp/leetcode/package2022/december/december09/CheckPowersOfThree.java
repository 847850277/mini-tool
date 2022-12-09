package com.zp.leetcode.package2022.december.december09;

/**
 * @author zhengpeng
 * @date 2022/12/9 9:07 上午
 * 判断一个数字是否可以表示成3的幂的和
 **/
public class CheckPowersOfThree {

    public static void main(String[] args) {
        int n = 91;
        CheckPowersOfThree c = new CheckPowersOfThree();
        System.out.println(c.checkPowersOfThree(n));


    }


    /**
     * 我们可以将 n 转换成 3 进制。如果 n 的 3 进制表示中每一位均不为 2，那么答案为 True，否则为 False
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }




}
