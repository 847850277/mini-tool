package com.zp.leetcode.package2023.november.november21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 美化数组的最少删除数
 */
public class MinDeletion {

    public static void main(String[] args) {
        MinDeletion minDeletion = new MinDeletion();
        //int[] array = new int[]{1,1,2,3,5};
        int[] array = new int[]{1,1,2,2,3,3};
        System.out.println(minDeletion.minDeletion(array));

    }


    /*
       由于本题删除一个元素后，删除元素的右侧的所有元素将向左移动。
       栈可以实现，而其他数据结构实现这个的时间复杂度太高，不推荐使用
    */
    public int minDeletion(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[0]);
        for (int i = 1; i < n; i++) {
        /*
            对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
         */
            //当栈的大小为偶数时，说明此时可以将数据直接添加到栈中
            if (deque.size() % 2 == 0) {
                deque.push(nums[i]);
            } else {
                int val = deque.peek();
                //当为奇数时，要判断是否与栈顶的元素相同，如果相同，则不能添加
                if (nums[i] == val){
                    continue;
                }
                deque.push(nums[i]);
            }
        }
        if (deque.size() % 2 == 0) return n - deque.size();
        //当栈的大小为奇数时，需要减去栈顶元素，所以删除的次数要加1
        return n - deque.size() + 1;
    }


}
