package com.zp.leetcode.package_2022.july.july28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2022/7/28 4:37 下午
 * 数组序号转换
 **/
public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length, idx = 0;
        for (int i : copy) {
            if (!map.containsKey(i)) map.put(i, ++idx);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = map.get(arr[i]);
        return ans;

    }
}
