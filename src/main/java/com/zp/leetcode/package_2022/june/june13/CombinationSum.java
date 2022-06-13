package com.zp.leetcode.package_2022.june.june13;

import java.util.*;

/**
 * @author zhengpeng
 * @date 2022/6/7 10:29 上午
 * 组合总和
 **/
public class CombinationSum {

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //空结果集合
        if(candidates[0] > target){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack1(candidates, target, result,new Stack<Integer>(), 0);
        return result;
    }

    private void backtrack1(int[] candidates, int target, List<List<Integer>> result, Stack<Integer> path, int index) {

            if (target == 0){//当target=0说明已经达到了结束条件
                result.add(new ArrayList<>(path));
                return;
            }
            if (target < 0){//当target<0说明前面的选择已经是错误的，要撤销
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                //做选择
                path.push(candidates[i]);
                target -= candidates[i];
                //递归进去
                backtrack1(candidates, target, result, path, i);
                //撤销选择
                path.pop();
                target += candidates[i];
            }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //空结果集合
        if(candidates[0] > target){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,candidates,target,result,new Stack<Integer>(),0);
        return result;
    }

    /**
     * 回溯
     * @param i
     * @param candidates
     * @param target
     * @param result
     * @param path
     */
    private void backtrack(int i, int[] candidates, int target, List<List<Integer>> result, Stack<Integer> path,Integer sum) {
        //推出递归函数
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        //推出递归函数
        if(sum > target){
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            final int candidate = candidates[i];
            sum = sum + candidate;
            path.push(candidate);
            backtrack(j,candidates,target,result,path,sum);
            sum = sum - candidate;
            path.pop();
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] array = new int[]{2,3,6,7};
        System.out.println(combinationSum.combinationSum1(array,7));
        //System.out.println();
    }
}
