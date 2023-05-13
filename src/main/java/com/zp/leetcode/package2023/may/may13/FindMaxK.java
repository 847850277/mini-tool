package com.zp.leetcode.package2023.may.may13;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2023/5/13 2:05 下午
 * 与对应负数同时存在的最大正整数
 **/
public class FindMaxK {

    public static void main(String[] args) {
        int[] array = new int[]{-1,2,-3,3};
        FindMaxK findMaxK = new FindMaxK();
        System.out.println(findMaxK.findMaxK(array));

    }

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if(sum > 0){
                right--;
            }else if(sum < 0){
                left++;
            }else {
                return nums[right];
            }
        }
        return -1;
    }
}
