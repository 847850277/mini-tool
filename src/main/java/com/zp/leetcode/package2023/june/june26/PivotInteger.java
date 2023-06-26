package com.zp.leetcode.package2023.june.june26;

/**
 * @author zhengpeng
 * @date 2023/6/26 10:12
 * 找出中枢整数
 **/
public class PivotInteger {

    public static void main(String[] args) {
        PivotInteger pivotInteger = new PivotInteger();
        int n = 8;
        System.out.println(pivotInteger.pivotInteger(n));
    }


    public int pivotInteger(int n) {
        int right = 0,left = 1;
        for (int i = 1; i <= n; i++) {
            right += i;
        }
        for (int i = 1; i <= n; i++) {
            if(right == left){
                return i;
            }
            right -= i;
            left += i + 1;
        }
        return -1;
    }
}
