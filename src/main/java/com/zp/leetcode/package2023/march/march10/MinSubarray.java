package com.zp.leetcode.package2023.march.march10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/3/10 1:56 下午
 * 使数组和能被P整除
 **/
public class MinSubarray {


    public static void main(String[] args) {


        int[] array = new int[]{6,3,5,2};
        int p = 9;
        MinSubarray minSubarray = new MinSubarray();
        System.out.println(minSubarray.minSubarray(array,p));


    }


    public int minSubarray(int[] nums, int p) {
        int x = 0;
        // 计算数组总和模p的余数x
        for (int num : nums) {
            x = (x + num) % p;
        }
        // 已经是p的倍数了 直接返回
        if (x == 0) {
            return 0;
        }
        int res = nums.length;
        // 前缀和
        int y = 0;
        int target;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // 记录-1位置的前缀和为0
        for (int i = 0; i < nums.length; i++) {
            // 计算前缀和f[i] mod p
            y = (y + nums[i]) % p;
            // 查找目标值
            target = (y - x + p) % p;
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
            // 记录前缀和f[i] mod p
            map.put(y, i);
        }
        // 如果res没有更新，说明没有找到可以移除的子数组，返回--1
        return res == nums.length ? -1 : res;
    }

}
