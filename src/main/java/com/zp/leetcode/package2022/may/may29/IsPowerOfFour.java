package com.zp.leetcode.package2022.may.may29;

/**
 * @author zhengpeng
 * @date 2022/5/29 8:28 下午
 **/
public class IsPowerOfFour {

    public boolean isPowerOfFour(int n) {
        long l = n;
        for (int i = 0; i <= 32; i++) {
            final double pow = Math.pow(4, i);
            long ll = (long) pow;
            if(ll == l){
                return true;
            }
            if(ll > l){
                return false;
            }
        }
        return false;
    }
}
