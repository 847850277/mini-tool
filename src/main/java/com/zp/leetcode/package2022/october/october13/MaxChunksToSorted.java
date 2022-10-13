package com.zp.leetcode.package2022.october.october13;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengpeng
 * @date 2022/10/13 9:58 上午
 *      最多能排序的块
 *  给定一个长度为n的整数数组array,它表示[0,n-1]范围内的整数的排列
 *  我们将array分割成若干块，并对每个块单独排序。将他们连接起来后，使得连接的结果和按照升序排列后的原数组相同
 *  返回数组能分得最多的块数量
 *
 **/
public class MaxChunksToSorted {


    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        int[] array = new int[]{4,3,2,1,0};
        System.out.println(maxChunksToSorted.maxChunksToSorted(array));
    }


    /**
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int num : arr) {
            int max = num;
            int min = num;
            //处理情况一和情况二，进行块的合并
            while (!queue.isEmpty() && (queue.peekLast()[1] > num || queue.peekLast()[0] > num)) {
                int[] ints = queue.pollLast();
                max = Math.max(max, ints[1]);
                min = Math.min(min, ints[0]);
            }
            queue.addLast(new int[]{min, max});
        }
        return queue.size();
    }

}
