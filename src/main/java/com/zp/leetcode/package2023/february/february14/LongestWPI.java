package com.zp.leetcode.package2023.february.february14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengpeng
 * @date 2023/2/14 9:11 上午
 * 表现良好的最长时间段
 **/
public class LongestWPI {

    public static void main(String[] args) {
        LongestWPI longestWPI = new LongestWPI();
        int[] array = new int[]{9,9,6,0,6,6,9};
        System.out.println(longestWPI.longestWPI(array));

    }


    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }


}
