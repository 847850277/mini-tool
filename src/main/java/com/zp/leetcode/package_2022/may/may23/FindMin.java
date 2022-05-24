package com.zp.leetcode.package_2022.may.may23;

import java.util.Arrays;

/**
 * @author zhengpeng
 * @date 2022/5/23 3:27 下午
 * 寻找排序数组的最小元素
 **/
public class FindMin {


    /**
     * 二分查找法寻找最小的元素
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public static void main(String[] args) {
        FindMin f = new FindMin();
        int[] array = new int[]{2,2,2,0,1};
        System.out.println(f.findMin(array));
    }
}
