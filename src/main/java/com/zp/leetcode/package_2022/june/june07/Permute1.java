package com.zp.leetcode.package_2022.june.june07;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/7 2:31 下午
 **/
public class Permute1 {
    List<List<Integer>> result = new ArrayList<>();
    //LinkedList<Integer> path = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        backtrack(nums, stack);
        return result;
    }

    public void backtrack(int[] nums, Stack<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果path中已有，则跳过
            if (path.contains(nums[i])) {
                continue;
            }
            path.push(nums[i]);
            backtrack(nums, path);
            path.pop();
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,4,5};
        int[] array = new int[]{1,2,3};
        Permute1 permute = new Permute1();
        System.out.println(permute.permute(array));

    }
}
