package com.zp.leetcode.package2023.february.february27;

/**
 * @author zhengpeng
 * @date 2023/2/27 9:19 上午
 * 递减数组元素使数组
 **/
public class MovesToMakeZigzag {

    public static void main(String[] args) {
        MovesToMakeZigzag m = new MovesToMakeZigzag();
        int[] array = new int[]{1,2,3};
        System.out.println(m.movesToMakeZigzag(array));
    }


    public int movesToMakeZigzag(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    public int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

}

