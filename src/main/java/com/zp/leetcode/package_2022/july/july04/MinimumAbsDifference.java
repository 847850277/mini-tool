package com.zp.leetcode.package_2022.july.july04;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/7/4 9:06 上午
 * 最小绝对值差
 **/
public class MinimumAbsDifference {


    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        Map<Integer,List<List<Integer>>> maps = new HashMap<Integer,List<List<Integer>>>();
        Integer minDiffAbsValue = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - arr[i - 1]);
            List<List<Integer>> orDefault = maps.getOrDefault(abs, new ArrayList<List<Integer>>());
            List<Integer> list = new ArrayList<>();
            list.add(arr[i - 1]);
            list.add(arr[i]);
            orDefault.add(list);
            maps.put(abs, orDefault);
            minDiffAbsValue = Math.min(minDiffAbsValue,abs);
        }
        return maps.get(minDiffAbsValue);
    }


    public static void main(String[] args) {
        MinimumAbsDifference minimumAbsDifference = new MinimumAbsDifference();
        //int[] arr = new int[]{4,2,1,3};
        //int[] arr = new int[]{1,3,6,10,15};
        int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference.minimumAbsDifference(arr));



    }



}
