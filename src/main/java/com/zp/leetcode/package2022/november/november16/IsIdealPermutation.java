package com.zp.leetcode.package2022.november.november16;

/**
 * @author zhengpeng
 * @date 2022/11/16 10:04 上午
 * 全局倒置与局部倒置
 * 一个局部倒置一定是一个全局倒置，因此要判断数组中的局部倒置的数量是否与全局
 * 倒置的数量相等，只需要检查有没有非局部倒置就可以了。这里的非局部倒置指的是
 * num[i] > num[j],其中 i < j - 1
 **/
public class IsIdealPermutation {


    public static void main(String[] args) {
        int[] array = new int[]{1,0,2};

        int[] array1 = new int[]{1,2,0};

        IsIdealPermutation isIdealPermutation = new IsIdealPermutation();
        System.out.println(isIdealPermutation.isIdealPermutation(array));

    }

    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minSuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }
}
