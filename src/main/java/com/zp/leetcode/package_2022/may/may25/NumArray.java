package com.zp.leetcode.package_2022.may.may25;

/**
 * @author zhengpeng
 * @date 2022/5/25 4:10 下午
 **/
public class NumArray {

    private int[] myNums = {};


    public NumArray(int[] nums) {
        myNums = nums;
    }


    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += myNums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int array[] = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(array);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));

    }
}
