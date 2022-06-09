package com.zp.leetcode.package_2022.june.june09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/9 9:58 上午
 * 含有重复元素的全排列
 **/
public class PermuteUnique1 {

    Stack<Integer> path = new Stack<Integer>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums,path,result);
        return result;
    }

    /**
     * 回溯
     * @param nums
     * @param path
     * @param result
     */
    private void backtrack(int[] nums, Stack<Integer> path, List<List<Integer>> result) {
        if(nums.length == path.size()) {
            result.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i - 1] == nums[i] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            //回溯
            backtrack(nums,path,result);
            //剔除路径
            path.pop();
            used[i] = false;
        }
    }


    public static void main(String[] args) {

    }

}
