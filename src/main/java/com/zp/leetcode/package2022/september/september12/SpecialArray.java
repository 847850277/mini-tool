package com.zp.leetcode.package2022.september.september12;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/9/12 4:00 下午
 * 特殊数组的特征值
 **/
public class SpecialArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5};
        SpecialArray s = new SpecialArray();
        System.out.println(s.specialArray(arr));
    }

    public int specialArray(int[] nums) {
        //left right
        int left = 1, right = nums.length + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num >= mid) {
                    count++;
                }
            }
            if (count == mid) {
                return mid;
            }
            if (count < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
