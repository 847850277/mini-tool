package com.zp.leetcode.package2023.december.december05;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        //int[] array = new int[]{2,7,11,15};
        //int target = 9;

        int[] array = new int[]{3,3};
        int target = 6;

        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(array,target));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valueIndexMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(valueIndexMap.containsKey(target - nums[i])){
                ans[0] = valueIndexMap.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            valueIndexMap.put(nums[i],i);
        }
        return null;
    }
}
