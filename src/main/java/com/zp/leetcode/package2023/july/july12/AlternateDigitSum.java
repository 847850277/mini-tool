package com.zp.leetcode.package2023.july.july12;

/**
 * @author zhengpeng
 * @date 2023/7/12 17:35
 **/
public class AlternateDigitSum {

    public static void main(String[] args) {
        AlternateDigitSum alternateDigitSum = new AlternateDigitSum();
        //int n = 521;
        //int n = 111;
        int n = 886996;
        System.out.println(alternateDigitSum.alternateDigitSum(n));
    }

    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        boolean negative = true;
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int val = Integer.parseInt(s.substring(i, i + 1));
            negative = !negative;
            if(negative){
                val = -val;
            }
            sum += val;
        }
        return sum;
    }
}
