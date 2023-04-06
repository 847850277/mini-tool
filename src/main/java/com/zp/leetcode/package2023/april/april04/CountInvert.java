package com.zp.leetcode.package2023.april.april04;

/**
 * @author zhengpeng
 * @date 2023/4/4 9:10 上午
 * 逆序对问题-分治法
 **/
public class CountInvert {

    public static void main(String[] args) {

    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return 0;
        }
        int[] copy = new int[len];
        System.arraycopy(nums,0,copy,0,len);
        int[] temp = new int[len];
        return reversePairs(copy,0,len-1,temp);
    }

    private int reversePairs(int[] copy, int i, int i1, int[] temp) {


        return 0;
    }
}
