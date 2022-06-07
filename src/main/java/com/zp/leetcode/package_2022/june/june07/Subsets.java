package com.zp.leetcode.package_2022.june.june07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengpeng
 * @date 2022/6/7 9:05 上午
 * 集合的所有子集
 **/
public class Subsets {

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(0,result,nums,new ArrayList<Integer>());
        return result;
    }

    /**
     * 回溯
     * @param i
     * @param result
     * @param nums
     * @param temp
     */
    private void backtrack(int i, List<List<Integer>> result, int[] nums, ArrayList<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++){
            temp.add(nums[j]);
            backtrack(j + 1,result,nums,temp);
            //回溯
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        final List<List<Integer>> subsets1 = subsets.subsets(array);
        System.out.println(subsets1);

    }
}
