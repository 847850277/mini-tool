package com.zp.leetcode.package_2022.may.may12;

/**
 * @author zhengpeng
 * @date 2022/5/12 9:37 上午
 * 2的幂
 **/
public class TwoPower {

    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 64; i++) {
            long power = (long) Math.pow(2,i);
            if(n == power){
                return true;
            }else if(power > n){
                return false;
            }
        }
        return false;
    }

}
