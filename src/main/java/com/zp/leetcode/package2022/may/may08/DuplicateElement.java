package com.zp.leetcode.package2022.may.may08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022-05-08 16:47
 * 重复元素
 **/
public class DuplicateElement {
    /**
     * 利用map
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> keyCounter = new HashMap((int) (nums.length * 1.75));
        for (int num : nums) {
            if(keyCounter.containsKey(num)){
                return true;
            }
            keyCounter.put(num,num);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5};
        DuplicateElement duplicateElement = new DuplicateElement();
        System.out.println(duplicateElement.containsDuplicate(array));

    }
}
