package com.zp.leetcode.package2022.september.september19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/9/19 9:10 上午
 * 按照频率将数组升序排序
 **/
public class FrequencySort {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,3,3};
        FrequencySort frequencySort = new FrequencySort();
        //final int[] ints = frequencySort.frequencySort(array);
        final int[] ints = frequencySort.frequencySort1(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    /**
     * 按照频率将数组升序排序
     * @param array
     * @return
     */
    public int[] frequencySort1(int[] array) {

        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i : array) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i : array) {
            list.add(i);
        }
        //排序
        list.sort((a,b) ->{
            int cnt1 = countMap.get(a), cnt2 = countMap.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });

        int[] result = new int[array.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }



    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> {
            int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

}
