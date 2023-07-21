package com.zp.leetcode.package2023.july.july21;

import java.util.PriorityQueue;

/**
 * @author zhengpeng
 * @date 2023/7/21 17:01
 * 满足不等式的最大值
 **/
public class FindMaxValueOfEquation {


    public static void main(String[] args) {

    }


    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int[] point : points) {
            int x = point[0], y = point[1];
            while (!heap.isEmpty() && x - heap.peek()[1] > k) {
                heap.poll();
            }
            if (!heap.isEmpty()) {
                res = Math.max(res, x + y - heap.peek()[0]);
            }
            heap.offer(new int[]{x - y, x});
        }
        return res;
    }
}
