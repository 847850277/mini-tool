package com.zp.leetcode.package_2022.june.june14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/6/14 5:15 下午
 * 找到所有数组中消失的数字
 **/
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int length = nums.length;
        int[] newArrays = new int[length];
        Map<Integer,Integer> keyMap = new HashMap<Integer,Integer>();
        for (int i = 1; i <= length; i++) {
            final int num = nums[i - 1];
            keyMap.put(num,num);
            newArrays[i - 1] = i;
        }

        for (int newArray : newArrays) {
            if(!keyMap.containsKey(newArray)){
                result.add(newArray);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        //int[] array = new int[]{1,2};
        int[] array = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(array));
    }

}
