package com.zp.leetcode.package_2022.june.june09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/9 8:58 上午
 * 全排列II
 **/
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        //int[] array = new int[]{1,2,3};
        int[] array = new int[]{1,1,2};
        System.out.println(permuteUnique.permuteUnique(array));


    }

    Stack<Integer> path = new Stack<Integer>();
    boolean[] used ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
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
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){


            if(used[i]){
                continue;
            }
            //解决了前面的问题
//            if(i > 0 && allFalse(used) && nums[i - 1] == nums[i]){
//                continue;
//            }

//            if(i > 0 && nums[i] == nums[i -1]){
//                continue;
//            }


            //调整为该方式
            if(i > 0 && !used[i -1] && nums[i - 1] == nums[i]){
                continue;
            }

            used[i] = true;
            path.push(nums[i]);
            backtrack(nums,path,result);
            path.pop();
            used[i] = false;
        }


    }

    /**
     * 所有都是false
     * @param used
     * @return
     */
    private boolean allFalse(boolean[] used) {
        for (boolean b : used) {
            if(b){
                return false;
            }
        }
        return true;
    }
}
