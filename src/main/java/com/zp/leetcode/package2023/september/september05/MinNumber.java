package com.zp.leetcode.package2023.september.september05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinNumber {

    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        int[] array1 = new int[]{4,1,3};
        //int[] array1 = new int[]{3,5,2,6};
        int[] array2 = new int[]{5,7};
        //int[] array2 = new int[]{3,1,7};
        System.out.println(minNumber.minNumber(array1,array2));
    }


    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i,i);
        }
        for (int i : nums2) {
            if(map.containsKey(i)){
                return i;
            }
        }
        String result = Math.min(nums1[0], nums2[0]) + String.valueOf(Math.max(nums1[0], nums2[0]));
        return Integer.valueOf(result);
    }
}
