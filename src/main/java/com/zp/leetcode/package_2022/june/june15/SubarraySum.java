package com.zp.leetcode.package_2022.june.june15;

import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/14 9:57 上午
 * 和为K的子数组
 **/
public class SubarraySum {




    public int subarraySum(int[] nums, int k) {

        return 0;

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
        //int[] array = new int[]{1,2,3};
        int[] array = new int[]{1,1,1};
        //int[] array = new int[]{1,1,1};
        //int[] array = new int[]{1,-1,0};
        System.out.println(subarraySum.subarraySum(array,2));
    }
}
