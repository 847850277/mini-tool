package com.zp.leetcode.package2023.february.february24;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2023/2/24 11:37 上午
 * 使数组中所有元素都等于零
 **/
public class MinimumOperations {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        MinimumOperations min = new MinimumOperations();
        System.out.println(min.minimumOperations(array));

    }


    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if(num > 0){
                set.add(num);
            }
        }
        return set.size();
    }
}
