package com.zp.leetcode.package2023.february.february15;

/**
 * @author zhengpeng
 * @date 2023/2/15 5:30 下午
 **/
public class IsGoodArray {

    public static void main(String[] args) {


    }
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor,num);
            if(divisor == 1){
                break;
            }
        }
        return divisor == 1;
    }

    public int gcd(int num1,int num2) {
        while (num2 != 0){
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
