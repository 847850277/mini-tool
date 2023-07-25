package com.zp.leetcode.package2023.july.july25;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhengpeng
 * @date 2023/7/25 09:17
 * 将数组和减半的最少操作次数
 **/
public class HalveArray {


    public static void main(String[] args) {
        HalveArray halveArray = new HalveArray();
        int[] array = new int[]{5,19,8,1};
        System.out.println(halveArray.halveArray(array));
    }


    public int halveArray(int[] nums) {
        PriorityQueue<Double> priority = new PriorityQueue<Double>(Comparator.reverseOrder());
        for (int num : nums) {
            priority.offer((double)num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double sum2 = 0.0d;
        while (sum2 < sum /2){
            double x = priority.poll();
            sum2 += x / 2;
            priority.offer(x / 2);
            res++;
        }
        return res;
    }
}
