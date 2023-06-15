package com.zp.leetcode.package2023.june.june15;

/**
 * @author zhengpeng
 * @date 2023/6/15 14:56
 * 归并排序求数组逆序对
 **/
public class ReversePairs1 {

    public static void main(String[] args) {


    }

    public int reversePairs(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int[] temp = new int[nums.length];
        return reversePairs(nums,0,nums.length - 1,temp);
    }


    private int reversePairs(int[] nums, int left, int right,int[] temp) {
        if(left == right){
            return 0;
        }
        int mid = (left + right) / 2;
        int leftSum = reversePairs(nums,left,mid,temp);
        int rightSum = reversePairs(nums,mid + 1,right,temp);
        //都构成逆序对
        if(nums[mid] <= nums[mid + 1]){
            return leftSum + rightSum;
        }
        int crossSum = mergeAndCount(nums,left,mid,right,temp);
        return leftSum + rightSum + crossSum;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right,int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right ; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }


}
