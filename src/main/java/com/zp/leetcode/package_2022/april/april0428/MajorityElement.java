package com.zp.leetcode.package_2022.april.april0428;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022-04-28 08:57
 **/
public class MajorityElement {

    /**
     * 主要元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int maxSizeCount = Integer.MIN_VALUE;
        Map<Integer, Integer> keyCounterMap = new HashMap<>(nums.length / 2);
        Map<Integer, Integer> maxSizeMap = new HashMap<>(nums.length / 2);
        for (int num : nums) {
            //先放计数器
            keyCounterMap.put(num, keyCounterMap.getOrDefault(num,0) + 1);
            //maxSizeCount = Math.max(maxSizeCount,keyCounterMap.get(num));
            if(maxSizeCount < keyCounterMap.get(num)){
                maxSizeCount = keyCounterMap.get(num);
                maxSizeMap.put(maxSizeCount,num);
            }
        }
        return maxSizeMap.get(maxSizeCount);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,1};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(array));
    }
}
