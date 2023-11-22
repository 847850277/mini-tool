package com.zp.leetcode.package2023.november.november22;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 美化数组的最少删除数
 */
public class MinDeletion {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,3,5};
        MinDeletion minDeletion = new MinDeletion();
        System.out.println(minDeletion.minDeletion(array));


    }

    public int minDeletion(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < len; i++) {
            if(stack.size() % 2 == 0){
                stack.push(nums[i]);
            }else {
                Integer val = stack.peek();
                if(val == nums[i]){
                    continue;
                }
                stack.push(nums[i]);
            }
        }
        if(stack.size() % 2 == 0){
            return len - stack.size();
        }else {
            return len - stack.size() + 1;
        }
    }

}
