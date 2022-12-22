package com.zp.leetcode.package2022.december.december22;

/**
 * @author zhengpeng
 * @date 2022/12/22 3:03 下午
 *
 **/
public class MaxSubArray {


    public static void main(String[] args) {
        //int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] array = new int[]{-1};
        //int[] array = new int[]{-2,-1};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(array));
    }


    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length;i++) {
            int num = nums[i];
            sum += num;
            if (sum < 0) {
                ans = Math.max(ans, sum);
                sum = 0;
            } else {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
