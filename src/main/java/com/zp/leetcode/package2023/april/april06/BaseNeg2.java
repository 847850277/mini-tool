package com.zp.leetcode.package2023.april.april06;

/**
 * @author zhengpeng
 * @date 2023/4/6 9:09 上午
 **/
public class BaseNeg2 {

    public static void main(String[] args) {

        BaseNeg2 baseNeg2 = new BaseNeg2();
        System.out.println(baseNeg2.baseNeg2(2));

    }

    public String baseNeg2(int n) {
        if(n == 0 || n == 1){
            return String.valueOf(n);
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            int remainder = n & 1;
            sb.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return sb.reverse().toString();
    }
}
