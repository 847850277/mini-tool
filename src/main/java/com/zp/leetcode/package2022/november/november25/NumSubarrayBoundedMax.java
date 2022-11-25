package com.zp.leetcode.package2022.november.november25;

/**
 * @author zhengpeng
 * @date 2022/11/25 9:08 上午
 * 区间子数组的个数
 **/
public class NumSubarrayBoundedMax {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8};
        int left = 3;
        int right = 7;
        NumSubarrayBoundedMax n = new NumSubarrayBoundedMax();
        System.out.println(n.numSubarrayBoundedMax(array, left, right));
    }


    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0,last1 = -1, last2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(left <= num && num <= right){
                last1 = i;
            }else if (num > right){
                last2 = i;
                last1 = -1;
            }
            if(last1 != -1){
                res += last1 - last2;
            }
        }
        return res;
    }
}
