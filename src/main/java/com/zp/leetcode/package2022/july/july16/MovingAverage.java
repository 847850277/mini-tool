package com.zp.leetcode.package2022.july.july16;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * @author zhengpeng
 * @date 2022/7/16 9:35 下午
 * 滑动窗口的平均值
 **/
public class MovingAverage {

    private int size;
    private Queue<Integer> queue;


    public Queue<Integer> getQueue() {
        return queue;
    }

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<Integer>(size);
    }

    public double next(int val) {
        if(queue.size() >= this.size) {
            queue.poll();
        }
        queue.add(val);
        double total = getTotal();
        return (total / queue.size());

    }

    private double getTotal() {
        double sum = 0d;
        final Queue<Integer> queue = getQueue();
        for (Integer integer : queue) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));

    }

}
