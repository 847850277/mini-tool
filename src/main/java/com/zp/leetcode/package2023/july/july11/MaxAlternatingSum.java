package com.zp.leetcode.package2023.july.july11;

/**
 * @author zhengpeng
 * @date 2023/7/11 09:38
 * 最大子序列交替和
 **/
public class MaxAlternatingSum {

    public static void main(String[] args) {

    }


    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }
}
