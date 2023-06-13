package com.zp.leetcode.package2023.june.june13;

/**
 * @author zhengpeng
 * @date 2023/6/13 13:51
 * 数组中不等三元的数目
 **/
public class UnequalTriplets {


    public static void main(String[] args) {

    }

    public int unequalTriplets(int[] nums) {
        int res = 0,n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

}
