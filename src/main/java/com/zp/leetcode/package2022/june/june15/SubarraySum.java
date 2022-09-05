package com.zp.leetcode.package2022.june.june15;

import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/14 9:57 上午
 * 和为K的子数组
 **/
public class SubarraySum {




    public int subarraySum(int[] nums, int k) {

        int slow = 0;
        int length = nums.length;
        int sum = 0;
        int count = 0;
        while (slow < length) {
            for (int i = slow; i < length; i++) {
                sum += nums[i];
                if(sum == k){
                    count++;
                }
                //和大于
                if(sum > k){
                    continue;
                }

            }
            slow++;
            sum = 0;
        }
        return count;

    }



    private int sumPath(Stack<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args) {

        SubarraySum subarraySum = new SubarraySum();
        int[] array = new int[]{1,2,3};
        //int[] array = new int[]{1,1,1};
        //int[] array = new int[]{1,1,1};
        //int[] array = new int[]{1,-1,0};
        System.out.println(subarraySum.subarraySum(array,3));
    }
}
