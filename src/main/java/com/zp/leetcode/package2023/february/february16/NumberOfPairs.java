package com.zp.leetcode.package2023.february.february16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/2/16 9:27 上午
 * 数组能形成多少数对
 **/
public class NumberOfPairs {


    public static void main(String[] args) {
        NumberOfPairs numberOfPairs = new NumberOfPairs();
        //int[] array = new int[]{1,3,2,1,3,2,2};
        //int[] array = new int[]{1,1};
        int[] array = new int[]{0};
        int[] ints = numberOfPairs.numberOfPairs(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }


    public int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num,countMap.getOrDefault(num,0) + 1);
        }
        int[] right = {0};
        int[] left = {0};
        countMap.forEach((k,v) ->{
            left[0] += v / 2;
            if(v % 2 != 0){
                right[0] += v % 2;
            }
        });
        return new int[]{left[0], right[0]};
    }
}
