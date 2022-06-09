package com.zp.leetcode.package_2022.june.june09;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/9 9:53 上午
 * 不含重复元素的全排列
 **/
public class Permute {

    Stack<Integer> path = new Stack<Integer>();
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums,path,result);
        return result;
    }

    private void backtrack(int[] nums, Stack<Integer> path, List<List<Integer>> result) {
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,path,result);
            path.pop();
            used[i] = false;
        }

    }

    public static void main(String[] args) {

    }
}
