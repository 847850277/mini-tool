package com.zp.leetcode.package_2022.may.may26;

/**
 * @author zhengpeng
 * @date 2022/5/26 9:54 上午
 **/
public class IsPowerOfThree {

    /**
     * 是否是3的幂
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        long l = n;
        for (int i = 0; i <= 32; i++) {
            final double pow = Math.pow(3, i);
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

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        //System.out.println(isPowerOfThree.isPowerOfThree(3));
        //System.out.println(isPowerOfThree.isPowerOfThree(27));
        System.out.println(isPowerOfThree.isPowerOfThree(2147483647));
    }
}
