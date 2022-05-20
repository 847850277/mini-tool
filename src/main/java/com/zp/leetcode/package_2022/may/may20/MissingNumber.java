package com.zp.leetcode.package_2022.may.may20;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/5/20 9:13 上午
 * 丢失的数字
 **/
public class MissingNumber {


    public int missingNumber(int[] nums) {
        int end = nums.length;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < end; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return end;
    }


    public static void main(String[] args) {

        int[] array = new int[]{0,1};
        //int[] array = new int[]{3,0,1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(array));

    }



}
