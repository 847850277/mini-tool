package com.zp.leetcode.package_2022.june.june09;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhengpeng
 * @date 2022/6/9 10:26 上午
 **/
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(0,result,array,new Stack<Integer>(),k);
        return result;
    }

    private void backtrack(int i, List<List<Integer>> result, int[] array, Stack<Integer> path, int k) {
        if(path.size() == k){
            result.add(new ArrayList<>(path));
        }
        for (int j = i; j < array.length; j++){
            path.add(array[j]);
            backtrack(j + 1,result,array,path,k);
            path.pop();
        }

    }


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
        //int[] array = new int[]{1,2,3,4};
        //int[] array = new int[]{1};
        Combine subsets = new Combine();
        //List<List<Integer>> subsets1 = subsets.subsets(array);
        //System.out.println(subsets1);
        List<List<Integer>> combine = subsets.combine(1, 1);
        System.out.println(combine);

    }
}
