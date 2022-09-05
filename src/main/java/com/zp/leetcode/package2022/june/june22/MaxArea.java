package com.zp.leetcode.package2022.june.june22;

/**
 * @author zhengpeng
 * @date 2022/6/21 10:27 上午
 * 盛最多水的容器
 **/
public class MaxArea {


    public int maxArea(int[] nums) {
        int left = 0 ;
        int right = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int maxArea = Math.min(nums[left], nums[right]) * (right - left);
            max = Math.max(maxArea,max);
            if(nums[left] >= nums[right]){
                right--;
            }else if(nums[left] < nums[right]){
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea max = new MaxArea();
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(max.maxArea(array));
    }


}
