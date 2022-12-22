package com.zp.leetcode.package2022.december.december22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/12/22 1:44 下午
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] array = new int[]{2,5,7};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(array,target));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int diffKey = target - nums[i];
            if (hashtable.containsKey(diffKey)) {
                return new int[]{hashtable.get(diffKey), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
