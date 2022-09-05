package com.zp.leetcode.package2022.august.august29;

/**
 * @author zhengpeng
 * @date 2022/8/29 2:30 下午
 * 重新排列数组
 **/
public class Shuffle {

    public static void main(String[] args) {

    }


    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0, j = n, k = 0; k < 2 * n; k++) {
            ans[k] = k % 2 == 0 ? nums[i++] : nums[j++];
        }
        return ans;
    }
}