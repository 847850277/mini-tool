package com.zp.leetcode.package2023.november.november20;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(array));
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        return maxSubArray(nums, 0, len - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if(left == right){
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return max3(maxSubArray(nums,left,mid),
                maxSubArray(nums,mid + 1,right),
                maxCrossingSum(nums,left,mid,right));
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for(int i = mid;i >= left;i--){
            sum += nums[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public int max3(int num1,int num2,int num3){
        return Math.max(num1,Math.max(num2,num3));
    }
}
