package com.zp.leetcode.package2022.september.september19;

import java.util.ArrayList;
import java.util.Collections;
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
        int[] array = new int[]{};
        FrequencySort frequencySort = new FrequencySort();
        final int[] ints = frequencySort.frequencySort(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

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
        Collections.sort(list, (a, b) -> {
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
