package com.zp.leetcode.package2022.july.july23;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhengpeng
 * @date 2022/7/23 3:14 下午
 * 重建序列
 **/
public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

}
