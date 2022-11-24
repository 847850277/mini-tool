package com.zp.leetcode.package2022.november.november24;

/**
 * @author zhengpeng
 * @date 2022/11/24 9:12 上午
 * 区间子数组的个数
 **/
public class NumSubarrayBoundedMax {


    public static void main(String[] args) {

        NumSubarrayBoundedMax n = new NumSubarrayBoundedMax();
        //int[] array = new int[]{2,1,4,3};
        int[] array = new int[]{2,9,2,5,6};
        int left = 2;
        int right = 8;
        System.out.println(n.numSubarrayBoundedMax(array,left,right));

    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }
}
