package com.zp.leetcode.package2022.september.september28;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2022/9/28 10:24 上午
 * 第k个数目
 **/
public class KthMagicNumber {



    public int getKthMagicNumber(int k) {
        int[] nums = new int[]{3, 5, 7};
        PriorityQueue<Long> q = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        q.add(1L); set.add(1L);
        while (!q.isEmpty()) {
            long t = q.poll();
            if (--k == 0) return (int) t;
            for (int x : nums) {
                if (!set.contains(x * t)) {
                    q.add(x * t); set.add(x * t);
                }
            }
        }
        return -1;
    }



}
